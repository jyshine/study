package com.shine.sample.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.lang.invoke.LambdaConversionException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static javax.persistence.FetchType.LAZY;

@Setter
@Getter
@Entity
@Table(name = "staff_roles")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class StaffRoles {


    @Id @Column(name = "staff_role_id")
    @GeneratedValue
    private Long id;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "staff_id")
    private Staffs staffs;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "role_id")
    private Roles roles;


    public static StaffRoles createStaffRoles(Staffs staffs, Roles roles){
        StaffRoles staffRoles = new StaffRoles();
        staffRoles.setStaffs(staffs);
        staffRoles.setRoles(roles);

        return staffRoles;
    }

    @Override
    public String toString() {
        return "StaffRoles{" +
                "id=" + id +
                ", staffs=" + staffs +
                ", roles=" + roles +
                '}';
    }
}
