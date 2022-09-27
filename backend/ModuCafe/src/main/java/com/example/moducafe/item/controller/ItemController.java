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
        return ResponseEntity.ok().body(itemService.getAllCoffees());
    }

    @PostMapping("/item/coffee")
    public ResponseEntity<CoffeeDto> createCoffee(@Valid @RequestParam CoffeeDto coffeeDto) {
        return ResponseEntity.ok().body(itemService.joinCoffee(coffeeDto));
    }

    @GetMapping("/item/coffee/{name}")
    public ResponseEntity<CoffeeDto> searchCoffee(@Valid @PathVariable String name) {
        return ResponseEntity.ok().body(itemService.findCoffeeByName(name));
    }

    @PutMapping("/item/coffee")
    public ResponseEntity<CoffeeDto> updateCoffee(@Valid @RequestParam CoffeeDto coffeeDto) {
        return ResponseEntity.ok().body(itemService.updateCoffeePrice(coffeeDto));
    }

    @DeleteMapping("/item/coffee/{name}")
    public ResponseEntity<String> removeCoffee(@Valid @PathVariable String name) {
        String deleteName = itemService.removeCoffee(name);
        return ResponseEntity.ok().body(deleteName);
    }

}
