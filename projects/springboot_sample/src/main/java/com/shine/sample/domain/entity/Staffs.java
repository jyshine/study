package com.shine.sample.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


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

    public Staffs(String username, String email, String password, String tell) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.tell = tell;

    }



    @Override
    public String toString() {
        return "Staffs{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", tell='" + tell + '\'' +
                '}';
    }
}
