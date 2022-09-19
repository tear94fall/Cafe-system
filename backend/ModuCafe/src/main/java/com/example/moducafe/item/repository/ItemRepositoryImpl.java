package com.example.moducafe.item.repository;

import com.example.moducafe.item.entity.Coffee;
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

    @Override
    public Coffee findOne(Long id) {
        return queryFactory
                .selectFrom(coffee)
                .where(coffee.id.eq(id))
                .fetchOne();
    }

    @Override
    public Coffee findByName(String name) {
        return queryFactory
                .selectFrom(coffee)
                .where(coffee.name.eq(name))
                .fetchOne();
    }
}