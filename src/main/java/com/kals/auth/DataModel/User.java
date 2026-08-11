package com.kals.auth.DataModel;

import io.kals.core.model.Audit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class User extends Audit {
    private Long id;
    private String userName;
    private String email;
    private String password;
    private Boolean isActive;
    private Role role;
    private ZonedDateTime lastLoginAt;
}
