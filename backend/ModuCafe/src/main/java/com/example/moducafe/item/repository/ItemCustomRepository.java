package com.example.moducafe.item.repository;

import com.example.moducafe.item.entity.Item;

import java.util.List;

public interface ItemCustomRepository {

    List<Item> findAllCoffees();
}
