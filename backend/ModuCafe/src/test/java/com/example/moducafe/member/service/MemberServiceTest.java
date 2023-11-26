package com.example.moducafe.member.service;

import com.example.moducafe.member.entity.Member;
import com.example.moducafe.member.repository.MemberRepository;
import com.example.moducafe.order.entity.Order;
import com.example.moducafe.order.repository.OrderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    OrderRepository orderRepository;

    @BeforeEach
    public void init() {
        for (int i = 0; i < 10; i++) {
            Member member = new Member();
            member.setName("name-" + i);
            member.setEmail("email" + i + "@test.com");
            member.setPhone("010"+i);

            for (int j = 0; j < 10; j++) {
                Order order = new Order();
                order.setName("item-" + i);
                order.setCount((i*10)+i);
                order.setPrice((i*1000)+i*100);
                order.setNumber(Integer.toString((i*10)+i));

                order.setMember(member);
                member.getOrders().add(order);

                orderRepository.save(order);
            }

            memberRepository.save(member);
        }
    }

    @Test
    @DisplayName("N+1 테스트")
    public void nPlusOneTest() {
        // given

        // when
        List<Member> all = memberRepository.findAll();

        // then
        for (Member member : all) {
            for (Order order : member.getOrders()) {
                order.getName();
            }
        }
    }

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

    @Test
    @DisplayName("회원 이메일 변경 테스트")
    public void changeName() {
        // given
        Member member = new Member();
        member.setName("James");
        member.setEmail("James@test.com");
        member.setPhone("010-1234-5678");

        // when
        Member save1 = memberRepository.save(member);
        String email1 = save1.getEmail();
        save1.setEmail("James1234@test.com");
        Member save2 = memberRepository.save(member);
        String email2 = save2.getEmail();

        // then
        assertNotEquals(email1, email2);
    }

    @Test
    @DisplayName("회원 삭제 테스트")
    public void removeMember() {
        // given
        Member member = new Member();
        member.setName("James");
        member.setEmail("James@test.com");
        member.setPhone("010-1234-5678");

        // when
        Member save = memberRepository.save(member);
        memberRepository.deleteById(save.getId());
        Member find = memberRepository.findByName(save.getName());

        // then
        assertNull(find);
    }

    @Test
    @DisplayName("회원-주문 테스트")
    public void memberOrderTest() {
        // given
        Member member = new Member();
        member.setName("James");
        member.setEmail("James@test.com");
        member.setPhone("010-1234-5678");

        Order order = new Order();
        order.setName("book");
        order.setCount(3);
        order.setPrice(20000);
        order.setNumber("1234");

        order.setMember(member);
        member.setOrders(Collections.singletonList(order));

        memberRepository.save(member);
        orderRepository.save(order);

        // when
        Member byName = memberRepository.findByName(member.getName());

        // then
        System.out.println(byName.getOrders().get(0).getPrice());
        assertEquals(byName.getOrders().get(0).getPrice(), order.getPrice());
    }

    @Test
    @DisplayName("init 테스트")
    public void initTest() {
        // given
        Member member = new Member();
        member.setName("James");
        member.setEmail("James@test.com");
        member.setPhone("010-1234-5678");

        Order order = new Order();
        order.setName("book");
        order.setCount(3);
        order.setPrice(20000);
        order.setNumber("1234");

        order.setMember(member);
        member.setOrders(Collections.singletonList(order));

        memberRepository.save(member);
        orderRepository.save(order);

        // when
        List<Member> all = memberRepository.findAll();

        // then
        all.forEach(m -> {System.out.println(m.getOrders().get(0).getName());});
    }
}