package com.shine.sample.repository;

import com.shine.sample.domain.entity.StaffRoles;
import com.shine.sample.domain.entity.Staffs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffRolesRepository extends JpaRepository<StaffRoles, Long> {

    StaffRoles findByStaffs(Staffs staffs);

}
