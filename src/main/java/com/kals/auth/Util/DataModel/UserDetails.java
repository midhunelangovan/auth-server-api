package com.kals.auth.Util.DataModel;

import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
public class UserDetails {
    private Long userId;
    private String userName;
    private String userRole;
    private Boolean isActive;
    private ZonedDateTime lastLoginAt;
    private ZonedDateTime createdAt;
    private ZonedDateTime modifiedAt;
}
