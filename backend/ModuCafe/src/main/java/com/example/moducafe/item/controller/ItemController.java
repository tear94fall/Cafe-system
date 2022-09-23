package com.example.moducafe.item.controller;

import com.example.moducafe.item.dto.CoffeeDto;
import com.example.moducafe.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/item/coffee")
    public ResponseEntity<List<CoffeeDto>> searchAllCoffees() {
        List<CoffeeDto> coffeeDtoList = itemService.getAllCoffees();
        return ResponseEntity.ok().body(coffeeDtoList);
    }
}
