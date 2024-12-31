package com.example.demo.controller;


import com.example.demo.dto.ClubDto;
import com.example.demo.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ClubController {

    private final ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/clubs")
    public String clubs(Model model) {
        List<ClubDto> clubs = clubService.getClubs();
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }
}
