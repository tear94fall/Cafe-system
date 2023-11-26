package com.example.moducafe.member.controller;

import com.example.moducafe.member.dto.MemberDto;
import com.example.moducafe.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/member")
    public ResponseEntity<List<MemberDto>> getMembers() {
        return ResponseEntity.ok().body(memberService.findAllMember());
    }

    @PostMapping("/member")
    public ResponseEntity<MemberDto> saveMember(@RequestBody MemberDto memberDto) {
        return ResponseEntity.ok().body(memberService.saveMember(memberDto));
    }

    @PutMapping("/member")
    public ResponseEntity<MemberDto> updateMember(@RequestBody MemberDto memberDto) {
        return ResponseEntity.ok().body(memberService.updateMember(memberDto));
    }

    @DeleteMapping("/member/{email}")
    public ResponseEntity<Long> deleteMember(@PathVariable String email) {
        return ResponseEntity.ok().body(memberService.deleteMember(email));
    }
}
