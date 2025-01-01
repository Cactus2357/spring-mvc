package com.example.demo.controller;

import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.MemberMapper;
import com.example.demo.model.Book;
import com.example.demo.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/members")
public class MemberController {

    private final MemberMapper memberMapper;

    @Autowired
    public MemberController(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    @GetMapping
    public String books(Model model) {
        var memberList = memberMapper.findAll();
        model.addAttribute("memberList", memberList);
        return "member-list";
    }

    @PostMapping
    public String addBook(@ModelAttribute("book") Member member) {
        if (member.getMemberId() == null) {
            memberMapper.insert(member);
        } else {
            memberMapper.update(member);
        }
        return "redirect:/books";
    }

}
