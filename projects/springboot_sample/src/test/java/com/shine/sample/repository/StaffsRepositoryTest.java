package com.shine.sample.repository;

import com.shine.sample.domain.entity.Roles;
import com.shine.sample.domain.entity.Staffs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@Rollback(false)
class StaffsRepositoryTest {

    @Autowired
    StaffsRepository staffsRepository;

    @Autowired
    RolesRepository rolesRepository;

    @BeforeEach
    void setUp() {

        Roles roles1 = new Roles("admin", "관리자");
        Roles roles2 = new Roles("user", "사용자");
        Roles roles3 = new Roles("guest", "손님");

        rolesRepository.saveAll(Arrays.asList(roles1, roles2, roles3));



    }

    @Test
    void 관리자_등록_테스트(){
        Staffs staffs = new Staffs("신준영","test@gmail.com","1234","01012341234");
        Staffs saved = staffsRepository.save(staffs);

        assertThat(staffs.getId()).isEqualTo(saved.getId());
    }


}