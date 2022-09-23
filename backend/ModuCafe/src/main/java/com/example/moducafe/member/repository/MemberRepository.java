package com.example.moducafe.member.repository;

import com.example.moducafe.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Item, Long>, MemberCustomRepository {
}
