package com.example.moducafe.item.entity;

import com.example.moducafe.item.dto.CoffeeDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@DiscriminatorValue("C")
@NoArgsConstructor
public class Coffee extends Item {
    private int shot;
    private boolean ice;

    public Coffee(CoffeeDto coffeeDto) {
        setName(coffeeDto.getName());
        setPrice(coffeeDto.getPrice());
        setQuantity(coffeeDto.getQuantity());
        setShot(coffeeDto.getShot());
        setIce(coffeeDto.isIce());
    }
}