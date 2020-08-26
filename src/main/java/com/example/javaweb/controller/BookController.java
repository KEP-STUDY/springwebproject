package com.example.javaweb.controller;

import com.example.javaweb.model.Board;
import com.example.javaweb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping
    public List<Board> readBoard() {
        return bookService.selectAll();
    }

    @PostMapping
    public Board createBoard(@RequestBody Board board) {
        return bookService.create(board);
    }

    @PutMapping("/{id}")
    public Board editBoard(@PathVariable Long id, @RequestBody Board updateData) {
        return bookService.update(id, updateData);
    }

    @DeleteMapping("/{id}")
    public void deleteBoard(@PathVariable Long id) {
        bookService.delete(id);
    }
}
