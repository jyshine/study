package com.shine.domain.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@Transactional //기존적으로 롤멕을 한다.
@SpringBootTest
class MemberTest {

    @Test
    void 테이블_생성_테스트() {
        Member member = new Member();
    }
}