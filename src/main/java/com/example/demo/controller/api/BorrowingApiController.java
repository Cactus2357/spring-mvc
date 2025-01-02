package com.example.demo.controller.api;

import com.example.demo.mapper.BorrowingMapper;
import com.example.demo.model.Borrowing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/borrows")
public class BorrowingApiController {
    private final BorrowingMapper mapper;
    private final BorrowingMapper borrowingMapper;

    @Autowired
    public BorrowingApiController(BorrowingMapper mapper, BorrowingMapper borrowingMapper) {
        this.mapper = mapper;
        this.borrowingMapper = borrowingMapper;
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

//    @GetMapping("{bookId}/available")
//    public ResponseEntity<Boolean> isAvailable(@PathVariable int bookId) {
//        return ResponseEntity.ok(borrowingMapper.isBookAvailable(bookId));
//    }

    @PostMapping
    public ResponseEntity<Borrowing> createGenre(@RequestBody Borrowing borrow) {
        if (!borrowingMapper.isBookAvailable(borrow.getBookId())) {
            return ResponseEntity.badRequest().body(null);
        }

        int id = mapper.insert(borrow);
        return ResponseEntity.ok().body(mapper.findById(id));
    }

    @PutMapping("{borrowingId}/return")
    public ResponseEntity<Borrowing> updateGenre(@PathVariable int borrowingId) {
        mapper.update(borrowingId);
        var newBorrowing = mapper.findById(borrowingId);
        return ResponseEntity.ok().body(newBorrowing);
    }
}
