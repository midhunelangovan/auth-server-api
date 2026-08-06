package com.kals.auth.Mapper;

import com.kals.auth.DataModel.User;
import com.kals.auth.EntityModel.UserEntity;
import io.kals.security.utils.AuthUtils;
import io.kals.core.mapper.BaseMapper;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;


@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<UserEntity, User> {

    @AfterMapping
    default void afterMappingToDto(@MappingTarget UserEntity userEntity, User user) {
        userEntity.setPassword(AuthUtils.encryptPassword(user.getPassword()));
    }

}
