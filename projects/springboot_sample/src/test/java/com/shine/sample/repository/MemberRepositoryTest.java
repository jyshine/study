package com.shine.sample.repository;

import com.shine.sample.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@Transactional
@SpringBootTest
@Rollback(false)
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void 저장(){
        Member member = new Member("준영","신","1234","jyshine3@gmail.com","19900324");
        Member member2 = new Member("테스터","신","1234","tester@gmail.com","20210512");

        Member savedMember = memberRepository.save(member);
        Optional<Member> findMember = memberRepository.findById(savedMember.getId());
        assertThat(savedMember).isEqualTo(findMember.get());


        Member savedMember2 = memberRepository.save(member2);
        Optional<Member> findMember2 = memberRepository.findById(savedMember2.getId());
        assertThat(savedMember2).isEqualTo(findMember2.get());
    }

    @Test
    void 조회_전체() {
        List<Member> memberAll = memberRepository.findAll();
        System.out.println("리스트 사이즈 : " +memberAll.size());
        for(Member member : memberAll){
            System.out.println(member.toString());
        }

        assertThat(memberAll.size()).isEqualTo(2);
    }

    @Test
    void 조회_email() {
        Member member = memberRepository.findByEmail("jyshine3@gmail.com");

        assertThat(member.getFirstname()).isEqualTo("준영");
    }

}