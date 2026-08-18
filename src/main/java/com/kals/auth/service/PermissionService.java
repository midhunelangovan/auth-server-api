package com.kals.auth.service;

import com.kals.auth.DataModel.Permission;
import com.kals.auth.EntityModel.PermissionEntity;
import com.kals.auth.Mapper.PermissionMapper;
import com.kals.auth.repository.PermissionRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PermissionService {

    private final PermissionMapper permissionMapper;
    private final PermissionRepository permissionRepository;

    public PermissionService(PermissionMapper permissionMapper, PermissionRepository permissionRepository) {
        this.permissionMapper = permissionMapper;
        this.permissionRepository = permissionRepository;
    }

    public List<Permission> getAllPermissionById(List<Long> permissionIds) {
        List<PermissionEntity> permissionEntityList = permissionRepository.findAllById(permissionIds);
        return permissionMapper.toDtoList(permissionEntityList);
    }

    public List<String> getPermissionCodeListById(List<Long> permissionIds) {
        List<Permission> permissionList = getAllPermissionById(permissionIds);
        return new ArrayList<>(permissionList.stream().map(Permission::getCode).toList());
    }

    public List<Permission> getAllPermissions() {

        List<PermissionEntity> permissionEntityList = permissionRepository.findAll();
        return permissionMapper.toDtoList(permissionEntityList);

    }
}
