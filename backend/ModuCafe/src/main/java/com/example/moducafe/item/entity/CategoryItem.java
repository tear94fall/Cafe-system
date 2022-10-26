package com.example.moducafe.item.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class CategoryItem {
    @Id
    @GeneratedValue
    @Column(name = "category_item_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id_")
    private Category order;

    @ManyToOne
    @JoinColumn(name = "item_id_")
    private Item item;
}