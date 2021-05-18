package com.shine.sample.domain.dto;


import com.shine.sample.domain.entity.Staffs;
import lombok.Data;


@Data
public class StaffsDto {

    private String username;

    private String email;

    private String tell;



    public StaffsDto(Staffs staffs) {
        this.username = staffs.getUsername();
        this.email = staffs.getEmail();
        this.tell = staffs.getTell();
    }

}
