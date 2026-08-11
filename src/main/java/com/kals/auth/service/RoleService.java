package com.kals.auth.service;

import com.kals.auth.DataModel.Role;
import com.kals.auth.EntityModel.RoleEntity;
import com.kals.auth.Mapper.RoleMapper;
import com.kals.auth.repository.RoleRepository;
import io.kals.core.service.AbstractCrudService;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends AbstractCrudService<RoleEntity, Role, Long> {

    public RoleService(RoleRepository roleRepository, RoleMapper roleMapper) {
        super(roleRepository, roleMapper);
    }
}
