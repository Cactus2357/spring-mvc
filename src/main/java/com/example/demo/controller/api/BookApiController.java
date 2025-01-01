package com.example.demo.controller.api;

import com.example.demo.mapper.BookMapper;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookApiController {
    private final BookMapper mapper;

    @Autowired
    public BookApiController(BookMapper mapper) {
        this.mapper = mapper;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getBooks() {
        List<Book> bookList = mapper.findAll();
        return ResponseEntity.ok().body(bookList);
    }

    @GetMapping("{bookId}")
    public ResponseEntity<Book> getBookById(@PathVariable("bookId") int bookId) {
        Book book = mapper.findById(bookId);
        return ResponseEntity.ok().body(book);
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        int id = mapper.insert(book);
        Book newBook = mapper.findById(id);
        return ResponseEntity.ok().body(newBook);
    }

    @PutMapping("{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable int bookId, @RequestBody Book book) {
        book.setBookId(bookId);
        mapper.update(book);
        Book updatedBook = mapper.findById(bookId);
        return ResponseEntity.ok().body(updatedBook);
    }

    @DeleteMapping("{bookId}")
    public ResponseEntity<Void> deleteBook(@PathVariable int bookId) {
        mapper.delete(bookId);
        return ResponseEntity.noContent().build();
    }
}
