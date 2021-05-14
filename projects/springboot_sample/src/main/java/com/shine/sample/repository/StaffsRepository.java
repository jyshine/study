package com.shine.sample.repository;

import com.shine.sample.domain.dto.StaffsDto;
import com.shine.sample.domain.entity.Staffs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StaffsRepository extends JpaRepository<Staffs,Long> {

    Staffs findByUsername(String name);

    @Query("select s.username from Staffs s")
    List<String> findUsernameList();

    @Query("select new com.shine.sample.domain.dto.StaffsDto(s.id, s.username, s.email, s.password, s.tell, sr.roleKey) from  Staffs s join  s.staffRoles sr")
    List<StaffsDto> findAllStaffsDto();

    @Query("select new com.shine.sample.domain.dto.StaffsDto(s.id, s.username, s.email, s.password, s.tell, sr.roleKey) from  Staffs s join  s.staffRoles sr where s.id = :id")
    StaffsDto findByIdStaffsDto(@Param("id") Long id);
}
