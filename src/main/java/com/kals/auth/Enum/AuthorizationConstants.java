package com.kals.auth.Enum;

import lombok.Getter;

@Getter
public enum AuthorizationConstants {

    USER_ID("userId"),
    USER_NAME("userName"),
    USER_ROLE("userRole"),
    EXPIRY("exp"),
    EMAIL("email");

    private final String field;

    AuthorizationConstants(String field) {
        this.field = field;
    }
}
