package com.shine.sample.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


@Getter
@Setter
@Entity
//@ToString(of = {"id","email","username","tell"})
@NoArgsConstructor
public class Staffs {

    @Id
    @GeneratedValue
    @Column(name = "staff_id")
    private Long id;

    @Column(name = "user_name")
    private String username;

    private String email;

    private String password;

    private String tell;

    private int active;

    @OneToMany(mappedBy = "staffs")   // cascade는 유의해서 사용해야한다.
    private List<StaffRoles> staffRoles = new ArrayList<>();

    public Staffs(String username, String email, String password, String tell,int active) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.tell = tell;
        this.active = active;



    }

    @Override
    public String toString() {
        return "Staffs{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", tell='" + tell + '\'' +
                ", staffRoles=" + staffRoles +
                '}';
    }
}
