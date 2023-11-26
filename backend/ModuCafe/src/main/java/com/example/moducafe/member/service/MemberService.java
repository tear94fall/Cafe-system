package com.example.moducafe.member.service;

import com.example.moducafe.member.dto.MemberDto;
import com.example.moducafe.member.entity.Member;
import com.example.moducafe.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    public List<MemberDto> findAllMember() {
        List<Member> memberList = memberRepository.findAll();

        return memberList.stream()
                .map(MemberDto::new)
                .collect(Collectors.toList());
    }

    public MemberDto saveMember(MemberDto memberDto) {
        return new MemberDto(memberRepository.save(new Member(memberDto)));
    }

    public MemberDto updateMember(MemberDto memberDto) {
        Member searchMember = memberRepository.findByEmail(memberDto.getEmail());
        searchMember.setName(memberDto.getName());
        searchMember.setPhone(memberDto.getPhone());

        Member save = memberRepository.save(searchMember);
        return new MemberDto(save);
    }

    public Long deleteMember(String email) {
        return memberRepository.deleteByEmail(email);
    }
}
