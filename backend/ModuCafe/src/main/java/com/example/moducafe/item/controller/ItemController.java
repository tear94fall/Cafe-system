package com.example.moducafe.item.controller;

import com.example.moducafe.item.dto.CoffeeDto;
import com.example.moducafe.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping("/item/coffees")
    public ResponseEntity<List<CoffeeDto>> searchAllCoffees() {
        List<CoffeeDto> coffeeDtoList = itemService.getAllCoffees();
        return ResponseEntity.ok().body(coffeeDtoList);
    }

    @PostMapping("/item/coffee")
    public ResponseEntity<CoffeeDto> searchCoffee(@Valid @RequestParam String name) {
        CoffeeDto search = itemService.findByName(name);
        return ResponseEntity.ok().body(search);
    }
}
