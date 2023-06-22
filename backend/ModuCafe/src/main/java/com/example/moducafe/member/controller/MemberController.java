package com.example.moducafe.member.controller;

import com.example.moducafe.member.dto.MemberDto;
import com.example.moducafe.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("member")
    public ResponseEntity<List<MemberDto>> getMembers() {
        return ResponseEntity.ok().body(memberService.findAllMember());
    }

    @PostMapping("member")
    public ResponseEntity<MemberDto> saveMember(@RequestBody MemberDto memberDto) {
        return ResponseEntity.ok().body(memberService.saveMember(memberDto));
    }
}
