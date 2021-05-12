package com.shine.domain.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberTest {

    @Test
    void 테이블_생성_테스트() {
        Member member = new Member();
    }
}