package com.kals.auth.Controller;

import com.kals.auth.Util.UserRequest;
import com.kals.auth.Util.UserResponse;
import com.kals.auth.service.AuthorizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("")
public class AuthenticationController {

    private final AuthorizationService authorizationService;

    public AuthenticationController(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    @PostMapping("/login")
    public ResponseEntity<UserResponse> userLoginValidation(
            @RequestBody UserRequest userRequest
    ) {
        UserResponse response = authorizationService.validateUserLogin(userRequest);
        return new ResponseEntity<>(response, HttpStatus.ACCEPTED);
    }

}
