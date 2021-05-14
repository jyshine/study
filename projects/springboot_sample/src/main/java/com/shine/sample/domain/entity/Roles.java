package com.shine.sample.domain.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Roles {

    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private Long id;


    @Column(name = "role_key")
    private String roleKey;

    @Column(name = "role_name")
    private String roleName;

    @OneToMany(mappedBy = "roles")
    private List<StaffRoles> staffRoles = new ArrayList<>();

    public Roles(String roleKey, String roleName) {
        this.roleKey = roleKey;
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "id=" + id +
                ", roleKey='" + roleKey + '\'' +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}
