package com.kals.auth.service;

import com.kals.auth.DataModel.User;
import com.kals.auth.EntityModel.UserEntity;
import com.kals.auth.Mapper.UserMapper;
import com.kals.auth.repository.UserRepository;
import io.kals.core.service.AbstractCrudService;
import io.kals.security.utils.AuthUtils;
import io.kals.core.exception.Exceptions.DataValidationException;
import io.kals.core.exception.Exceptions.ResourceNotFoundException;
import io.kals.core.utility.UserUtil;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;

@Service
public class UserService extends AbstractCrudService<UserEntity, User, Long> {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        super(userRepository, userMapper);
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void delete(Long id) {
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isEmpty()) {
            throw new RuntimeException("AUTH_404");
        }
        UserEntity user = userEntity.get();
        user.setIsActive(false);
        userRepository.save(userEntity.get());
    }

    public User getMyUserProfile(Long id) {
        Optional<UserEntity> userDetails = userRepository.findById(id);
        if (userDetails.isEmpty()) {
            throw new ResourceNotFoundException("AUTH_404");
        }
        return userMapper.toDto(userDetails.get());
    }

    public void resetPassword(Map<String, String> updatePassword) {
        Long id = UserUtil.getUserId();
        Optional<UserEntity> userEntity = userRepository.findById(id);
        if (userEntity.isPresent()) {
            UserEntity user = userEntity.get();
            if (AuthUtils.validatePassword(updatePassword.get("oldPassword"), user.getPassword())) {
                String newPassword = AuthUtils.encryptPassword(updatePassword.get("newPassword"));
                user.setPassword(newPassword);
                userRepository.save(user);
            } else {
                throw new DataValidationException("AUTH_40402");
            }
        }
    }
}
