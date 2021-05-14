package com.shine.sample.repository;

import com.shine.sample.domain.entity.Roles;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolesRepository extends JpaRepository<Roles, Long> {
    Roles findByRoleKey(String rolekey);

}
