package com.example.moducafe.member.dto;

import com.example.moducafe.member.entity.Member;
import com.example.moducafe.order.dto.OrderDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@NoArgsConstructor
public class MemberDto {
    private String name;
    private String email;
    private String phone;
    private List<OrderDto> orderDtoList;

    public MemberDto(Member member) {
        setName(member.getName());
        setEmail(member.getEmail());
        setPhone(member.getPhone());
        List<OrderDto> orders = member.getOrders().stream()
                .map(OrderDto::new)
                .collect(Collectors.toList());
        setOrderDtoList(orders);
    }
}
