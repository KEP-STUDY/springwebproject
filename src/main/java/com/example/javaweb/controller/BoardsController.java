package com.example.javaweb.controller;

import com.example.javaweb.model.Board;
import com.example.javaweb.service.BoardService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.HashMap;

@RestController
public class BoardsController {

    private final BoardService boardService;

    public BoardsController(BoardService boardService) {
        this.boardService = boardService;
    }

    @PostMapping("/boards")
    public ResponseEntity<Board> create(@RequestBody HashMap<String, Object> map) {
        return new ResponseEntity<>(boardService.insert(map), HttpStatus.CREATED);
    }

    @GetMapping("/boards/{id}")
    public ResponseEntity<Board> find(@PathVariable long id) {
        Board board = boardService.find(id);
        if (board == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "board not found"
            );
        }

        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @PutMapping("/boards/{id}")
    public ResponseEntity<Board> update(@PathVariable int id, @RequestBody HashMap<String, Object> map) {
        Board board = boardService.update(id, map);
        if (board == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "board not found"
            );
        }

        return new ResponseEntity<>(board, HttpStatus.OK);
    }

    @DeleteMapping("/boards/{id}")
    public ResponseEntity<Object> delete(@PathVariable int id) {
        if (!boardService.delete(id)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "board not found"
            );
        }

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
