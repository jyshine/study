package com.shine.sample.domain.dto;

import lombok.Data;

@Data
public class StaffsDto {

    private Long staffId;
    private String username;
    private String email;
    private String password;
    private String tell;
    private String roleKey;

    public StaffsDto(Long id, String username, String email, String password, String tell, String roleKey) {
        this.staffId = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.tell = tell;
        this.roleKey = roleKey;
    }
}
