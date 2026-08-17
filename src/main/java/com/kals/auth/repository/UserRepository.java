package com.kals.auth.repository;

import com.kals.auth.EntityModel.UserEntity;
import io.kals.core.repository.AbstractBaseRepository;


public interface UserRepository extends AbstractBaseRepository<UserEntity, Long> {
    UserEntity findUserByEmailAndIsActive(String userName, Boolean isActive);

}
