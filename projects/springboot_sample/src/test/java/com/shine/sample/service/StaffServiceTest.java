package com.shine.sample.service;

import com.shine.sample.domain.dto.StaffsDto;
import com.shine.sample.domain.entity.Roles;
import com.shine.sample.domain.entity.StaffRoles;
import com.shine.sample.domain.entity.Staffs;
import com.shine.sample.repository.RolesRepository;
import com.shine.sample.repository.StaffRolesRepository;
import com.shine.sample.repository.StaffsRepository;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;


@SpringBootTest
@Transactional
@Rollback(false)
class StaffServiceTest {

    @Autowired
    StaffsRepository staffsRepository;

    @Autowired
    RolesRepository rolesRepository;

    @Autowired
    StaffRolesRepository staffRolesRepository;


    @BeforeEach
    void setUp() {

        Roles roles1 = new Roles("admin", "관리자");
        Roles roles2 = new Roles("user", "사용자");
        Roles roles3 = new Roles("guest", "손님");

        rolesRepository.saveAll(Arrays.asList(roles1, roles2, roles3));

        staffRolesRepository.save(
                StaffRoles.createStaffRoles(
                        staffsRepository.save(new Staffs("test111","test@gmail.com","1234","01012341234",1)),
                        rolesRepository.findByRoleKey("admin")));

        staffRolesRepository.save(
                StaffRoles.createStaffRoles(
                        staffsRepository.save(new Staffs("test222","test222@gmail.com","1234","01012341234",1)),
                        rolesRepository.findByRoleKey("admin")));


        List<Roles> roles = rolesRepository.findAll();
        Staffs staff = new Staffs("test333", "333@gmail.com", "1234", "33333333", 1);

        Staffs savedStaff = staffsRepository.save(staff);
        List<StaffRoles> staffRoles = new ArrayList<>();

        for(Roles role: roles){
            staffRoles.add(StaffRoles.createStaffRoles(staff,role));
        }

        staffRolesRepository.saveAll(staffRoles);


    }

    @Test
    void 관리자_등록_테스트(){
        Staffs staffs = new Staffs("aaaaa","aaaaa@gmail.com","1234","01012341234",1);
//        Staffs savedStaffs = staffsRepository.save(staffs);

    }
    @Test
    void 관리자_조회_리스트_테스트_01(){
        List<Staffs> staffsList = staffsRepository.findAll();

    }
    @Test
    void 관리자_조회_리스트_테스트(){
        List<StaffRoles> staffsList = staffRolesRepository.findAllStaffRoles();

        for(StaffRoles staffsDto : staffsList){
            System.out.println(staffsDto.toString());
        }

//        assertThat(staffsDtoList.size()).isEqualTo(2);
    }
//
//    @Test
//    void 관리자_조회_테스트(){
//        Staffs test1 = staffsRepository.findByUsername("test111");
//        StaffsDto staffsDto = staffsRepository.findByIdStaffsDto(test1.getId());
//
//        assertThat(staffsDto.getUsername()).isEqualTo(test1.getUsername());
//    }

    @Test
    void 관리자_정보_수정(){
        Staffs test1 = staffsRepository.findByUsername("test111");
        test1.setEmail("hahaha@gmail.com");
        test1.setTell("01042462442");
        Staffs test2 = staffsRepository.findByUsername("test111");

        assertThat(test1.getEmail()).isEqualTo(test2.getEmail());

        System.out.println("####################");
        System.out.println(test2.getStaffRoles());
    }

    @Test
    void 관리자_권한_수정(){
        long id = 2;
        Staffs test1 = staffsRepository.findByUsername("test111");

        Optional<Roles> roles = rolesRepository.findById(id);
        StaffRoles staffRoles = staffRolesRepository.findByStaffs(test1);
        staffRoles.setRoles(roles.get());
        System.out.println(staffRoles);
    }



}