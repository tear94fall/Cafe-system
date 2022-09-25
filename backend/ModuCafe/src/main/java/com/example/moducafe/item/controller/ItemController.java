package com.example.moducafe.item.controller;

import com.example.moducafe.item.dto.CoffeeDto;
import com.example.moducafe.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/item/coffee/{name}")
    public ResponseEntity<CoffeeDto> searchCoffee(@Valid @PathVariable String name) {
        CoffeeDto search = itemService.findByName(name);
        return ResponseEntity.ok().body(search);
    }

    @PostMapping("/item/coffee")
    public ResponseEntity<CoffeeDto> createCoffee(@Valid @RequestParam CoffeeDto coffeeDto) {
        CoffeeDto join = itemService.join(coffeeDto);
        return ResponseEntity.ok().body(join);
    }
}
