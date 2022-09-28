package com.example.moducafe.member.service;

import com.example.moducafe.item.dto.CoffeeDto;
import com.example.moducafe.member.dto.MemberDto;
import com.example.moducafe.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberDto findMemberByName(String name) {
        return new MemberDto(memberRepository.findByName(name));
    }
}
