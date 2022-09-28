package com.example.moducafe.member.repository;

import com.example.moducafe.member.entity.Member;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import static com.example.moducafe.member.entity.QMember.member;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberCustomRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public Member findByName(String name) {
        return queryFactory
                .selectFrom(member)
                .where(member.name.eq(name))
                .fetchOne();
    }
}
