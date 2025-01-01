package com.example.demo.controller.api;

import com.example.demo.mapper.BorrowingMapper;
import com.example.demo.model.Borrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/borrowing")
public class BorrowingApiController {
    private final BorrowingMapper mapper;

    @Autowired
    public BorrowingApiController(BorrowingMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<Borrowing>> getGenres() {
        var genres = mapper.findAll();
        return ResponseEntity.ok().body(genres);
    }

    @GetMapping("{borrowingId}")
    public ResponseEntity<Borrowing> getGenreById(@PathVariable int borrowingId) {
        var genre = mapper.findById(borrowingId);
        return ResponseEntity.ok().body(genre);
    }

    @PostMapping
    public ResponseEntity<Borrowing> createGenre(@RequestBody Borrowing genre) {
        int id = mapper.insert(genre);
        return ResponseEntity.ok().body(mapper.findById(id));
    }

    @PutMapping("{borrowingId}")
    public ResponseEntity<Borrowing> updateGenre(@PathVariable int borrowingId, @RequestBody Borrowing borrowing) {
        borrowing.setBorrowId(borrowingId);
        mapper.update(borrowing);
        var newBorrowing = mapper.findById(borrowingId);
        return ResponseEntity.ok().body(newBorrowing);
    }
}
