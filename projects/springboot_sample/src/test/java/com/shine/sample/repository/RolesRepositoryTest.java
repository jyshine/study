package com.shine.sample.repository;

import com.shine.sample.domain.entity.Roles;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class RolesRepositoryTest {

    @Autowired
    RolesRepository rolesRepository;

    @Test
    void 권한_생선 (){

        Roles roles1 = new Roles("admin", "관리자");
        Roles roles2 = new Roles("user", "사용자");
        Roles roles3 = new Roles("guest", "손님");

        rolesRepository.save(roles1);
        rolesRepository.save(roles2);
        rolesRepository.save(roles3);
    }
}