package com.shine.sample.domain.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Setter
@Getter
@Entity
public class StaffRoles {


    @Id @Column(name = "staff_role_id")
    @GeneratedValue
    private Long id;

    @Column(name = "staff_id")
    private Long staffId;

    @Column(name = "role_key")
    private String roleKey;
}
