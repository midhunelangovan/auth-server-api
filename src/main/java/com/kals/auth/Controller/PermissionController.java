package com.kals.auth.Controller;

import com.kals.auth.DataModel.Permission;
import com.kals.auth.service.PermissionService;
import io.kals.core.constants.HeaderUtilConstants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/permissions")
public class PermissionController {

    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping("")
    public List<Permission> getAllPermissions(
            @RequestHeader(HeaderUtilConstants.HEADER_AUTHORIZATION_TOKEN) String authToken
    ) {
        return permissionService.getAllPermissions();
    }

}
