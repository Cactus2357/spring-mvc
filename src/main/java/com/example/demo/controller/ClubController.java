package com.example.demo.controller;


import com.example.demo.dto.ClubDto;
import com.example.demo.model.Club;
import com.example.demo.service.ClubService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("search")
    public String clubsSearch(@RequestParam("q") String query, Model model) {
        Optional<List<ClubDto>> optionalClubList = clubService.getClubsByTitle(query);
        model.addAttribute("clubs", optionalClubList.get());
        model.addAttribute("query", query);
        return "clubs-list";
    }

    @GetMapping("/{clubId}")
    public String club(@PathVariable int clubId, Model model) {
        ClubDto clubDto = clubService.findClubById(clubId);
        model.addAttribute("club", clubDto);
        return "club-detail";
    }

    @GetMapping("/new")
    public String createClubForm(Model model) {
        Club club = new Club();
        model.addAttribute("club", club);
        return "clubs-create";
    }

    @GetMapping("/{clubId}/delete")
    public String deleteClub(@PathVariable("clubId") int clubId) {
        clubService.deleteClubById(clubId);
        return "redirect:/clubs";
    }

    @PostMapping("/new")
    public String createClub(@Valid @ModelAttribute("club") ClubDto club, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("club", club);
            return "clubs-create";
        }

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
    public String updateClub(
            @PathVariable("clubId") Integer clubId,
            @Valid @ModelAttribute("club") ClubDto club,
            BindingResult result) {

        if (result.hasErrors()) {
            return "clubs-edit";
        }

        club.setId(clubId);
        clubService.updateClub(club);
        return "redirect:/clubs";
    }

}
