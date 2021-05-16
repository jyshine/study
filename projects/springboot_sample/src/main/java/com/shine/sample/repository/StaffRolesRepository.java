package com.shine.sample.repository;

import com.shine.sample.domain.dto.StaffsDto;
import com.shine.sample.domain.entity.StaffRoles;
import com.shine.sample.domain.entity.Staffs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StaffRolesRepository extends JpaRepository<StaffRoles, Long> {

    StaffRoles findByStaffs(Staffs staffs);

    @Query(" select sr from StaffRoles sr join sr.roles r where sr.staffs.id in :staffIds ")
    List<StaffRoles> findByStaffId(@Param("staffIds") List<Long> staffIds);

//    @Query("select sr from StaffRoles sr left join  sr.staffs s left join  sr.roles r")
//    List<StaffRoles> findAllStaffRoles();

}
