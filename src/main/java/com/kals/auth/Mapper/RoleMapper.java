package com.kals.auth.Mapper;

import com.kals.auth.DataModel.Role;
import com.kals.auth.EntityModel.RoleEntity;
import io.kals.core.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper extends BaseMapper<RoleEntity, Role> {
}
