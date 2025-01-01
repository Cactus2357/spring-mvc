package com.example.demo.controller.api;

import com.example.demo.mapper.MemberMapper;
import com.example.demo.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/members")
public class MemberApiController {
    private final MemberMapper mapper;

    @Autowired
    public MemberApiController(MemberMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<Member>> getMembers() {
        var members = mapper.findAll();
        return ResponseEntity.ok().body(members);
    }

    @GetMapping("{memberId}")
    public ResponseEntity<Member> getMemberById(@PathVariable int memberId) {
        var member = mapper.findById(memberId);
        return ResponseEntity.ok().body(member);
    }

    @PostMapping
    public ResponseEntity<Member> createMember(@RequestBody Member member) {
        int id = mapper.insert(member);
        return ResponseEntity.ok().body(mapper.findById(id));
    }

    @PutMapping("{memberId}")
    public ResponseEntity<Member> updateMember(@PathVariable int memberId, @RequestBody Member member) {
        member.setMemberId(memberId);
        mapper.update(member);
        var updatedMember = mapper.findById(memberId);
        return ResponseEntity.ok().body(updatedMember);
    }

//    @DeleteMapping("{memberId}")
//    public ResponseEntity<Void> deleteMember(@PathVariable int memberId) {
////        memberMapper.delete(memberId);
//        return ResponseEntity.noContent().build();
//    }
}
