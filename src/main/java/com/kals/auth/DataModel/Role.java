package com.kals.auth.DataModel;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Role {

    private Long id;
    private String name;
    private String description;
    private List<Permission> permissions;

}
