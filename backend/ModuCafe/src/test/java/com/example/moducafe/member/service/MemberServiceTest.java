package com.example.moducafe.member.service;

import com.example.moducafe.item.entity.Coffee;
import com.example.moducafe.item.repository.ItemRepository;
import com.example.moducafe.member.entity.Member;
import com.example.moducafe.member.repository.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @DisplayName("회원 추가 테스트")
    public void AddMemberTest() {
        // given
        Member member = new Member();
        member.setName("James");
        member.setEmail("James@test.com");
        member.setPhone("010-1234-5678");

        // when
        Member save = memberRepository.save(member);

        // then
        assertEquals(member, save);
    }

    @Test
    @DisplayName("회원 조회 테스트")
    public void getMemberTest() {
        // given
        Member member = new Member();
        member.setName("James");
        member.setEmail("James@test.com");
        member.setPhone("010-1234-5678");

        // when
        Member save = memberRepository.save(member);
        Member find = memberRepository.findByName("James");

        // then
        assertEquals(save, find);
    }
}