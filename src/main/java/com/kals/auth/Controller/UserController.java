package com.kals.auth.Controller;

import com.kals.auth.DataModel.User;
import com.kals.auth.EntityModel.UserEntity;
import com.kals.auth.service.UserService;
import io.kals.core.constants.HeaderUtilConstants;
import io.kals.core.controller.implementation.AbstractRestApiController;
import io.kals.core.model.PageResponse;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController extends AbstractRestApiController<UserEntity, User, Long> {

    private final UserService userService;

    protected UserController(UserService userService) {
        super(userService);
        this.userService = userService;
    }

    @GetMapping("/get-all")
    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
    public PageResponse<User> getAll(
            @RequestHeader(name = HeaderUtilConstants.HEADER_AUTHORIZATION_TOKEN) String authToken,
            Pageable pageable,
            @RequestParam(name = "q", required = false) String query
    ) {
        return userService.getAll(pageable, query );
    }

    @GetMapping("/user-profile/{id}")
    @PreAuthorize("hasRole('ROLE_SUPER_ADMIN')")
    public ResponseEntity<User> viewUserProfile(
            @RequestHeader(name = HeaderUtilConstants.HEADER_AUTHORIZATION_TOKEN) String authToken
            , @PathVariable Long id
    ) {
        User userDetails = userService.getMyUserProfile(id);
        return new ResponseEntity<>(userDetails, HttpStatus.OK);
    }

    @PatchMapping("/reset-password")
    public ResponseEntity<Void> updateUserPassword(
            @RequestHeader(name = HeaderUtilConstants.HEADER_AUTHORIZATION_TOKEN) String authToken,
            @RequestBody Map<String, String> updatePassword
    ) {
        userService.resetPassword(updatePassword);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


}
