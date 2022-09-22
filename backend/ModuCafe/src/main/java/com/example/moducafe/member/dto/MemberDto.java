package com.example.moducafe.member.dto;

import com.example.moducafe.member.entity.Member;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MemberDto {
    private String name;
    private String email;
    private String phone;

    public MemberDto(Member member) {
        setName(member.getName());
        setEmail(member.getEmail());
        setPhone(member.getEmail());
    }
}
