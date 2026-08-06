package com.kals.auth.Util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UserResponse {
    private Boolean isLoggedIn;
    private String Token;
}
