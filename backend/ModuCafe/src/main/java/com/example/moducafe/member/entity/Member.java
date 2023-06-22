package com.example.moducafe.member.entity;

import com.example.moducafe.member.dto.MemberDto;
import com.example.moducafe.order.entity.Order;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@Table(name = "members")
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String phone;

    @OneToMany(mappedBy = "member", fetch = FetchType.LAZY)
    private List<Order> orders = new ArrayList<>();

    public Member(MemberDto memberDto) {
        setName(memberDto.getName());
        setEmail(memberDto.getEmail());
        setPhone(memberDto.getPhone());
        List<Order> orders = memberDto.getOrderDtoList().stream()
                .map(Order::new)
                .collect(Collectors.toList());
        setOrders(orders);
    }
}
