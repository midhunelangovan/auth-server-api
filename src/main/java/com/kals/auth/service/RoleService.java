package com.kals.auth.service;

import com.kals.auth.DataModel.Permission;
import com.kals.auth.DataModel.Role;
import com.kals.auth.EntityModel.PermissionEntity;
import com.kals.auth.EntityModel.RoleEntity;
import com.kals.auth.EntityModel.RolePermission;
import com.kals.auth.Mapper.PermissionMapper;
import com.kals.auth.Mapper.RoleMapper;
import com.kals.auth.repository.PermissionRepository;
import com.kals.auth.repository.RoleRepository;
import io.kals.core.exception.Exceptions.ResourceNotFoundException;
import io.kals.core.service.AbstractCrudService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService extends AbstractCrudService<RoleEntity, Role, Long> {

    private final PermissionMapper permissionMapper;
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
    private final PermissionService permissionService;

    public RoleService(RoleRepository roleRepository, RoleMapper roleMapper, PermissionRepository permissionRepository, PermissionMapper permissionMapper, RoleRepository roleRepository1, RoleMapper roleMapper1, PermissionService permissionService) {
        super(roleRepository, roleMapper);
        this.permissionMapper = permissionMapper;
        this.roleRepository = roleRepository1;
        this.roleMapper = roleMapper1;
        this.permissionService = permissionService;
    }

    public List<String> rolePermissions(List<Long> roleIds) {
        List<RoleEntity> roleEntities = roleRepository.findAllById(roleIds);
        List<Long> permissionIds = new ArrayList<>();
        for (RoleEntity role : roleEntities) {
            for (PermissionEntity permission : role.getPermissions()) {
                permissionIds.add(permission.getId());
            }
        }
        return permissionService.getPermissionCodeListById(permissionIds);
    }

    public Role createRolePermissions(RolePermission rolePermission) {
        List<Permission> permission = permissionService.getAllPermissionById(rolePermission.getPermissionId());
        Optional<RoleEntity> role = roleRepository.findById(rolePermission.getRoleId());
        if (role.isEmpty()) {
            throw new ResourceNotFoundException("AUTH_NA_01");
        }
        RoleEntity roleRes = role.get();
        roleRes.setPermissions(permissionMapper.toEntityList(permission));
        RoleEntity roleUpdated = roleRepository.save(roleRes);
        return roleMapper.toDto(roleUpdated);
    }

    @Override
    public void beforeUpdate(Long id, Role dto) {
        dto.setId(id);
    }
}
