package com.kals.auth.Controller;


import com.kals.auth.DataModel.Role;
import com.kals.auth.EntityModel.RoleEntity;
import com.kals.auth.EntityModel.RolePermission;
import com.kals.auth.service.RoleService;
import io.kals.core.constants.HeaderUtilConstants;
import io.kals.core.controller.implementation.RestApiControllerImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/roles")
public class RoleController extends RestApiControllerImpl<RoleEntity, Role, Long> {

    public static final String resourceName = "roles";
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        super(resourceName, roleService);
        this.roleService = roleService;
    }


    @PostMapping("/permissions")
    public Role createUserRolePermissions(@RequestHeader(name = HeaderUtilConstants.HEADER_AUTHORIZATION_TOKEN) String authToken, @RequestBody RolePermission rolePermission) {
        return roleService.createRolePermissions(rolePermission);
    }

}
