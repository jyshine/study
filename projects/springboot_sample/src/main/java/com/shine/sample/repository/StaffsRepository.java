package com.shine.sample.repository;

import com.shine.sample.domain.entity.Staffs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffsRepository extends JpaRepository<Staffs,Long> {

    Staffs findByUsername(String name);
}
