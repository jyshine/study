package com.shine.sample.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "staff_roles")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StaffRoles {


    @Id @Column(name = "staff_role_id")
    @GeneratedValue
    private Long id;

    @Column(name = "role_key")
    private String roleKey;

//    @OneToMany(mappedBy = "staffroles") //외래키아 없는 쪽에 mappedBy를 입력 하는걸 권장
//    private List<Staffs> staffs = new ArrayList<>();


    public StaffRoles(String roleKey) {
        this.roleKey = roleKey;
    }
}
