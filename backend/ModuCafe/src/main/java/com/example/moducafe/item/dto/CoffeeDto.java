package com.example.moducafe.item.dto;

import com.example.moducafe.item.entity.Coffee;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CoffeeDto {

    private String name;
    private int price;
    private int quantity;
    private int shot;
    private boolean ice;


    public CoffeeDto(Coffee coffee) {
        setName(coffee.getName());
        setPrice(coffee.getPrice());
        setQuantity(coffee.getQuantity());
        setShot(coffee.getShot());
        setIce(coffee.isIce());
    }
}
