package com.example.moducafe.order.dto;

import com.example.moducafe.member.dto.MemberDto;
import com.example.moducafe.order.entity.Order;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderDto {
    private String number;
    private String name;
    private int count;
    private int price;
    private MemberDto memberDto;

    public OrderDto(Order order) {
        setNumber(order.getNumber());
        setName(order.getName());
        setCount(order.getCount());
        setPrice(order.getPrice());
        setMemberDto(new MemberDto(order.getMember()));
    }
}
