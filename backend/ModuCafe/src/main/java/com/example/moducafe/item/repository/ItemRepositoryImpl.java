package com.example.moducafe.item.repository;

import com.example.moducafe.item.entity.Item;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.example.moducafe.item.entity.QCoffee.coffee;
import static com.example.moducafe.item.entity.QItem.item;

@RequiredArgsConstructor
public class ItemRepositoryImpl implements ItemCustomRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Item> findAllCoffees() {
        return queryFactory
                .selectFrom(item)
                .leftJoin(coffee).on(coffee.eq(item))
                .fetch();
    }
}