package com.example.demo.controller.api;

import com.example.demo.mapper.GenreMapper;
import com.example.demo.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/genres")
public class GenreApiController {
    private final GenreMapper mapper;

    @Autowired
    public GenreApiController(GenreMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<Genre>> getGenres() {
        var genres = mapper.findAll();
        return ResponseEntity.ok().body(genres);
    }

    @GetMapping("{genreId}")
    public ResponseEntity<Genre> getGenreById(@PathVariable int genreId) {
        var genre = mapper.findById(genreId);
        return ResponseEntity.ok().body(genre);
    }

    @PostMapping
    public ResponseEntity<Genre> createGenre(@RequestBody Genre genre) {
        int id = mapper.insert(genre);
        return ResponseEntity.ok().body(mapper.findById(id));
    }

    @PutMapping("{genreId}")
    public ResponseEntity<Genre> updateGenre(@PathVariable int genreId, @RequestBody Genre genre) {
        genre.setGenreId(genreId);
        mapper.update(genre);
        var updatedGenre = mapper.findById(genreId);
        return ResponseEntity.ok().body(updatedGenre);
    }

    @DeleteMapping("{genreId}")
    public ResponseEntity<Void> deleteGenre(@PathVariable int genreId) {
        mapper.delete(genreId);
        return ResponseEntity.noContent().build();
    }
}
