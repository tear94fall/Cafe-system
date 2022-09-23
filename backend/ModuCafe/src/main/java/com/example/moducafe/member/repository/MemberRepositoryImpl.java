package com.example.moducafe.member.repository;

import com.example.moducafe.item.repository.ItemCustomRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberCustomRepository{

    private final JPAQueryFactory queryFactory;
}
