package com.example.moducafe.item.controller;

import com.example.moducafe.item.dto.CoffeeDto;
import com.example.moducafe.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping("/item/coffee")
    public ResponseEntity<List<CoffeeDto>> searchAllCoffees() {
        List<CoffeeDto> coffeeDtoList = itemService.getAllCoffees();
        return ResponseEntity.ok().body(coffeeDtoList);
    }
}
