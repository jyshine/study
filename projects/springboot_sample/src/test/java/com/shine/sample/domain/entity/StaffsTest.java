package com.shine.sample.domain.entity;

import com.shine.sample.repository.StaffsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(false)
class StaffsTest {




    @Test
    void staffs_entity_test() {
        Staffs staffs = new Staffs(

        );
    }
}