package com.kals.auth.DataModel;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Permission {

    private Long id;
    private String name;
    private String code;
    private Long applicationId;
    private String description;

}
