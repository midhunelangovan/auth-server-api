package com.kals.auth.repository;

import com.kals.auth.EntityModel.RoleEntity;
import io.kals.core.repository.AbstractBaseRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends AbstractBaseRepository<RoleEntity, Long> {
}
