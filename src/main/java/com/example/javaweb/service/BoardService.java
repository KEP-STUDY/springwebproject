package com.example.javaweb.service;

import com.example.javaweb.model.Board;
import com.example.javaweb.repository.BoardRepository;
import com.example.javaweb.response.BoardCreateResponse;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class BoardService {
    final private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Board find(int id) {
        return boardRepository.find(id);
    }

    public BoardCreateResponse insert(HashMap<String, Object> map) {
        final Board board = new Board.Builder(map).build();
        int id = boardRepository.insert(board);
        return new BoardCreateResponse(id);
    }

    public boolean delete(int id) {
        return boardRepository.delete(id);
    }

    public Board update(int id, HashMap<String, Object> map) {
        final Board board = new Board.Builder(map).build();
        return boardRepository.update(id, board);
    }
}
