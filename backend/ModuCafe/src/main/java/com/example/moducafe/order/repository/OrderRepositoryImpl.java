package com.example.moducafe.order.repository;

import com.example.moducafe.order.entity.Order;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.example.moducafe.order.entity.QOrder.order;

@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderCustomRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public Order findByNumber(String number) {
        return queryFactory
                .selectFrom(order)
                .where(order.number.eq(number))
                .fetchOne();
    }
}