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
    @DisplayName("주문 추가 테스트")
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

    @Test
    @DisplayName("주문 조회 테스트")
    public void getMemberTest() {
        // given
        Order order = new Order();
        order.setNumber("1234");
        order.setName("Jason");
        order.setCount(3);
        order.setPrice(12000);

        // when
        Order save = orderRepository.save(order);
        Order find = orderRepository.findByNumber(save.getNumber());

        // then
        assertEquals(save, find);
    }

    @Test
    @DisplayName("주문 가격 변경 테스트")
    public void changeName() {
        // given
        Order order = new Order();
        order.setNumber("1234");
        order.setName("Jason");
        order.setCount(3);
        order.setPrice(12000);

        // when
        Order save1 = orderRepository.save(order);
        int price1 = save1.getPrice();
        save1.setPrice(15000);
        Order save2 = orderRepository.save(save1);
        int price2 = save2.getPrice();

        // then
        assertNotEquals(price1, price2);
    }

    @Test
    @DisplayName("주문 삭제 테스트")
    public void removeMember() {
        // given
        Order order = new Order();
        order.setNumber("1234");
        order.setName("Jason");
        order.setCount(3);
        order.setPrice(12000);

        // when
        Order save = orderRepository.save(order);
        orderRepository.deleteById(save.getId());
        Order find = orderRepository.findByNumber(save.getNumber());

        // then
        assertNull(find);
    }
}