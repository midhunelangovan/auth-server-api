package com.kals.auth.service;

import com.kals.auth.EntityModel.UserEntity;
import com.kals.auth.Enum.AuthorizationConstants;
import com.kals.auth.Util.UserRequest;
import com.kals.auth.Util.UserResponse;
import com.kals.auth.repository.UserRepository;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.kals.core.exception.Exceptions.AccessDeniedException;
import io.kals.security.utils.AuthUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.time.ZonedDateTime;
import java.util.Date;


@Service
public class AuthorizationService {

    private final UserRepository userRepository;

    @Value("${auth.jwt.secret}")
    private String secretKey;

    @Value(("${jwt.expiration}"))
    private Long tokenExpiryTime;

    public AuthorizationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse validateUserLogin(UserRequest userRequest) {
        UserEntity userEntity = userRepository.findUserByEmailAndIsActive(userRequest.getUserName(), true);
        if (userEntity == null) {
            throw new AccessDeniedException("AUTH_40401");
        }
        if (!AuthUtils.validatePassword(userRequest.getPassword(), userEntity.getPassword())) {
            throw new AccessDeniedException("AUTH_40402");
        }
        userEntity.setLastLoginAt(ZonedDateTime.now());
        userRepository.save(userEntity);

        String token = createToken(userEntity);

        UserResponse response = new UserResponse();
        response.setIsLoggedIn(true);
        response.setToken(token);
        return response;
    }

    private String createToken(UserEntity userEntity) {

        SecretKey key = Keys.hmacShaKeyFor(
                secretKey.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                .subject(userEntity.getEmail())
                .claim(AuthorizationConstants.EMAIL.getField(), userEntity.getEmail())
                .claim(AuthorizationConstants.USER_ID.getField(), userEntity.getId())
                .claim(AuthorizationConstants.USER_ROLE.getField(), userEntity.getRole().toString())
                .expiration(new Date(System.currentTimeMillis() + tokenExpiryTime))
                .signWith(key)
                .compact();
    }

}
