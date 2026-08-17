package com.kals.auth.Mapper;

import com.kals.auth.DataModel.Permission;
import com.kals.auth.EntityModel.PermissionEntity;
import io.kals.core.mapper.BaseMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper extends BaseMapper<PermissionEntity, Permission> {
}
