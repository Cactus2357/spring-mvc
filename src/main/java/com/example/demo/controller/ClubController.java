package com.example.demo.controller;


import com.example.demo.dto.ClubDto;
import com.example.demo.model.Club;
import com.example.demo.service.ClubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/clubs")
public class ClubController {

    private final ClubService clubService;

    @Autowired
    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping
    public String clubs(Model model) {
        List<ClubDto> clubs = clubService.getClubs();
        model.addAttribute("clubs", clubs);
        return "clubs-list";
    }

    @GetMapping("/new")
    public String createClubForm(Model model) {
        Club club = new Club();
        model.addAttribute("club", club);
        return "clubs-create";
    }

    @PostMapping("/new")
    public String createClub(@ModelAttribute("club") Club club) {
        clubService.save(club);
        return "redirect:/clubs";
    }


    @GetMapping("/{clubId}/edit")
    public String clubEdit(@PathVariable int clubId, Model model) {
        ClubDto club = clubService.findClubById(clubId);
        model.addAttribute("club", club);
        return "clubs-edit";
    }

    @PostMapping("/{clubId}/edit")
    public String updateClub(@PathVariable("clubId") Integer clubId, @ModelAttribute("club") Club club) {
        club.setId(clubId);
        clubService.updateClub(club);
        return "redirect:/clubs";
    }

}
