package com.example.moducafe.item.service;

import com.example.moducafe.item.entity.Coffee;
import com.example.moducafe.item.entity.Item;
import com.example.moducafe.item.repository.ItemRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ItemServiceTest {

    @Autowired
    ItemService itemService;

    @Autowired
    ItemRepository itemRepository;

    @Test
    @DisplayName("커피 메뉴 추가 테스트")
    public void AddCoffeeTest() throws Exception {
        // given
        Coffee coffee = new Coffee();
        coffee.setName("아메리카노");
        coffee.setPrice(2500);

        // when
        Coffee join = itemService.join(coffee);

        // then
        assertEquals(coffee, join);
    }

    @Test
    @DisplayName("커피 메뉴 이름으로 조회 테스트")
    public void getCoffeeByNameTest() throws Exception {
        // given
        Coffee coffee = new Coffee();
        coffee.setName("에스프레소");
        coffee.setPrice(3000);

        // when
        itemService.join(coffee);
        Coffee find = itemService.findByName("에스프레소");

        // then
        assertEquals(coffee.getName(), find.getName());
    }

    @Test
    @DisplayName("메뉴 가격 변경 테스트")
    public void changePrice() {
        // given
        Coffee coffee = new Coffee();
        coffee.setName("아메리카노");
        coffee.setPrice(2500);

        // when
        Coffee join = itemService.join(coffee);
        int price = join.getPrice();
        Item item = itemService.updatePrice(join.getId(), 3500);

        // then
        assertNotEquals(price, item.getPrice());
    }

    @Test
    @DisplayName("메뉴 삭제 테스트")
    public void removeItem() {
        // given
        Coffee coffee = new Coffee();
        coffee.setName("아메리카노");
        coffee.setPrice(2500);

        // when
        Coffee join = itemService.join(coffee);
        itemService.removeItem(join);
        Coffee find = itemService.findByName(join.getName());

        // then
        assertNull(find);
    }
}