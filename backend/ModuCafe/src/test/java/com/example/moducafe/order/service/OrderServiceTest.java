package com.example.moducafe.order.service;

import com.example.moducafe.order.entity.Order;
import com.example.moducafe.order.repository.OrderRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class OrderServiceTest {

    @Autowired
    OrderRepository orderRepository;

    @Test
    @DisplayName("회원 추가 테스트")
    public void AddMemberTest() {
        // given
        Order order = new Order();
        order.setName("Jason");
        order.setCount(3);
        order.setPrice(12000);

        // when
        Order save = orderRepository.save(order);

        // then
        assertEquals(order, save);
    }
}