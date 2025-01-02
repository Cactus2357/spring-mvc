package com.example.demo.controller;

import com.example.demo.mapper.BookMapper;
import com.example.demo.mapper.BorrowingMapper;
import com.example.demo.mapper.GenreMapper;
import com.example.demo.mapper.MemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/borrows")
public class BorrowingController {
    private final BorrowingMapper borrowingMapper;
    private final BookMapper bookMapper;
    private final MemberMapper memberMapper;

    @Autowired
    public BorrowingController(BorrowingMapper borrowingMapper, BookMapper bookMapper, MemberMapper memberMapper) {
        this.borrowingMapper = borrowingMapper;
        this.bookMapper = bookMapper;
        this.memberMapper = memberMapper;
    }

    @GetMapping
    public String genres(Model model) {
        var borrowingList = borrowingMapper.findAll();
        model.addAttribute("bookList", bookMapper.findAllAvailable());
        model.addAttribute("memberList", memberMapper.findAll());
        model.addAttribute("borrowingList", borrowingList);
        return "borrowing-list";
    }
}
