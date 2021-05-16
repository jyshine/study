package com.shine.sample.repository;

import com.shine.sample.domain.dto.StaffsDto;
import com.shine.sample.domain.entity.StaffRoles;
import com.shine.sample.domain.entity.Staffs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface StaffRolesRepository extends JpaRepository<StaffRoles, Long> {

    StaffRoles findByStaffs(Staffs staffs);

    @Query("select sr from StaffRoles sr join fetch sr.staffs s join fetch sr.roles r")
    List<StaffRoles> findAllStaffRoles();

}
