package com.kals.auth.service;

import io.kals.security.service.PermissionService;
import io.kals.security.utils.UserUtil;
import org.springframework.stereotype.Service;


@Service
public class PermissionRetrievalService implements PermissionService {

    private final UserService userService;

    public PermissionRetrievalService(UserService userService) {
        this.userService = userService;
    }

    @Override
    public String getUserPermissions(Long userId) {
        return userService.getUserPermissions(userId);
    }
}
