package com.example.moducafe.item.repository;

import com.example.moducafe.item.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long>, ItemCustomRepository {
}
