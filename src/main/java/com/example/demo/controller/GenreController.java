package com.example.demo.controller;

import com.example.demo.mapper.GenreMapper;
import com.example.demo.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/genres")
public class GenreController {
    private final GenreMapper genreMapper;

    @Autowired
    public GenreController(GenreMapper genreMapper) {
        this.genreMapper = genreMapper;
    }

    @GetMapping
    public String genres(Model model) {
        var genreList = genreMapper.findAll();
        model.addAttribute("genreList", genreList);
        return "genre-list";
    }

//    @PostMapping
//    public String addGenre(@ModelAttribute("genre") Genre genre) {
//        if (genre.getGenreId() == null) {
//            genreMapper.insert(genre);
//        } else {
//            genreMapper.update(genre);
//        }
//        return "redirect:/genres";
//    }

//    @GetMapping("/{genreId}/delete")
//    public String deleteBook(@PathVariable("genreId") Integer genreId) {
//        genreMapper.delete(genreId);
//        return "redirect:/genres";
//    }
}
