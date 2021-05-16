package com.shine.sample.repository;

import com.shine.sample.domain.dto.StaffsDto;
import com.shine.sample.domain.entity.Staffs;
import org.hibernate.mapping.Join;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StaffsRepository extends JpaRepository<Staffs,Long> {

    Staffs findByUsername(String name);

    @Query("select s.username from Staffs s")
    List<String> findUsernameList();






}
