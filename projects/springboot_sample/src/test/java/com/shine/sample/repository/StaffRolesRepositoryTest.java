package com.shine.sample.repository;

import com.shine.sample.domain.entity.Roles;
import com.shine.sample.domain.entity.StaffRoles;
import com.shine.sample.domain.entity.Staffs;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class StaffRolesRepositoryTest {

    @Autowired
    StaffsRepository staffsRepository;

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    StaffRolesRepository staffRolesRepository;

    @BeforeEach
    void setUp() {
//        Staffs staffs = new Staffs("신준영","test@gmail.com","1234","01012341234");
//        staffsRepository.save(staffs);
//        Roles roles1 = new Roles("admin", "관리자");
//        Roles roles2 = new Roles("user", "사용자");
//        Roles roles3 = new Roles("guest", "손님");
//
//        rolesRepository.save(roles1);
//        rolesRepository.save(roles2);
//        rolesRepository.save(roles3);
    }
//
//    @Test
//    void 관리_권한_매핑_저장(){
//        Staffs staff = staffsRepository.findByUsername("신준영");
//        Roles roles = rolesRepository.findByRoleKey("admin");
//
//        System.out.println(staff.toString());
//        System.out.println(roles.toString());
//
//        StaffRoles staffRoles = new StaffRoles(staff.getId(), roles.getRoleKey());
//        staffRolesRepository.save(staffRoles);
//    }



}