package com.example.moducafe.member.repository;

import com.example.moducafe.member.entity.Member;

public interface MemberCustomRepository {
    Member findByName(String name);
}
