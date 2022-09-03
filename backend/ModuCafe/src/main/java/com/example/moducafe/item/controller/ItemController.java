package com.example.moducafe.item.controller;

import com.example.moducafe.item.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ItemController {

    @Autowired
    private ItemService itemService;
}
