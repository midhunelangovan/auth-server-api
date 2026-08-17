package com.kals.auth.Mapper;

import com.kals.auth.DataModel.User;
import com.kals.auth.EntityModel.RoleEntity;
import com.kals.auth.EntityModel.UserEntity;
import io.kals.security.utils.AuthUtils;
import io.kals.core.mapper.BaseMapper;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Mapper(componentModel = "spring")
public abstract class UserMapper implements BaseMapper<UserEntity, User> {

    @Autowired
    RoleMapper roleMapper;

    @AfterMapping
    protected void afterMappingToEntity(@MappingTarget UserEntity userEntity, User user) {
        if (user.getPassword() != null && !user.getPassword().isEmpty()) {
            userEntity.setPassword(AuthUtils.encryptPassword(user.getPassword()));
        }
    }

    @AfterMapping
    protected void afterMappingToDto(UserEntity userEntity, @MappingTarget User user) {
        if (userEntity.getRoles() != null) {
            List<RoleEntity> roleEntityList = userEntity.getRoles().stream().toList();
            user.setRole(roleMapper.toDtoList(roleEntityList));
        }
        user.setPassword(null);
    }


}
