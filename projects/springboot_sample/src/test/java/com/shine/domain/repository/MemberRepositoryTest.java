package com.shine.domain.repository;

import com.shine.domain.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
@Transactional
@Rollback(false)
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void save(){
        Member member = new Member("shine",32);
        Member savedMember = memberRepository.save(member);
        Optional<Member> findMember = memberRepository.findById(savedMember.getId());

        assertThat(savedMember).isEqualTo(findMember.get());
    }

}