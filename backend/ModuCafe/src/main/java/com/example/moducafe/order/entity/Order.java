package com.example.moducafe.order.entity;

import com.example.moducafe.member.entity.Member;
import com.example.moducafe.order.dto.OrderDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@Table(name = "orders")
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public Order(OrderDto orderDto) {
        setNumber(orderDto.getNumber());
        setName(orderDto.getName());
        setCount(orderDto.getCount());
        setPrice(orderDto.getPrice());
        setMember(new Member(orderDto.getMemberDto()));
    }
}
