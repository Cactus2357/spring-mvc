package com.example.demo.controller;

import com.example.demo.mapper.BookMapper;
import com.example.demo.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookMapper bookMapper;

    @Autowired
    public BookController(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @GetMapping
    public String books(Model model) {
        var bookList = bookMapper.findAll();
        model.addAttribute("bookList", bookList);
        return "book-list";
    }

    @PostMapping
    public String addBook(@ModelAttribute("book") Book book) {
        if (book.getBookId() == null) {
            bookMapper.insert(book);
        } else {
            bookMapper.update(book);
        }
        return "redirect:/books";
    }

    @GetMapping("/{bookId}/delete")
    public String deleteBook(@PathVariable("bookId") Integer bookId) {
        bookMapper.delete(bookId);
        return "redirect:/books";
    }


}
