package com.example.moducafe.order.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @NotNull
    private String number;

    @NotNull
    private String name;

    @NotNull
    private int count;

    @NotNull
    private int price;
}
