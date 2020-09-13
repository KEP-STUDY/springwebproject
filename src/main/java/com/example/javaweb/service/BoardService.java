package com.example.javaweb.service;

import com.example.javaweb.model.Board;
import com.example.javaweb.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class BoardService {
    final private BoardRepository boardRepository;

    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public Board find(long id) {
        return boardRepository.findById(id).orElse(null);
    }

    public Board insert(HashMap<String, Object> map) {
        final Board board = new Board(map);
        return boardRepository.save(board);
    }

    public boolean delete(long id) {
        if (!boardRepository.existsById(id)) {
            return false;
        }

        boardRepository.deleteById(id);
        return true;
    }

    public Board update(long id, HashMap<String, Object> map) {
        final Board updateBoard = new Board(map);
        final Optional<Board> savedBoard = boardRepository.findById(id);
        if (savedBoard.isEmpty()) {
            return null;
        }

        savedBoard.get().setTitle(updateBoard.getTitle());
        savedBoard.get().setBody(updateBoard.getBody());

        return boardRepository.save(savedBoard.get());
    }
}
