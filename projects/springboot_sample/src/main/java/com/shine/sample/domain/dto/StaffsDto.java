package com.shine.sample.domain.dto;

import lombok.Data;

@Data
public class StaffsDto {

    private Long staffId;
    private String username;
    private String email;
    private String password;
    private String tell;
    private String roleName;
    private String roleKey;


    public StaffsDto(Long staffId, String username, String email, String password, String tell, String roleName, String roleKey) {
        this.staffId = staffId;
        this.username = username;
        this.email = email;
        this.password = password;
        this.tell = tell;
        this.roleName = roleName;
        this.roleKey = roleKey;
    }
}
