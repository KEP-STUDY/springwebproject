package com.example.javaweb.service;

import com.example.javaweb.model.Board;
import com.example.javaweb.model.User;
import com.example.javaweb.repository.BoardRepository;
import com.example.javaweb.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class BoardService {
    final private BoardRepository boardRepository;
    final private UserRepository userRepository;

    public BoardService(BoardRepository boardRepository, UserRepository userRepository) {
        this.boardRepository = boardRepository;
        this.userRepository = userRepository;
    }

    public Board find(long id) {
        return boardRepository.findById(id).orElse(null);
    }

    public Board insert(HashMap<String, Object> map) {
        final Integer id = (Integer) map.get("user_id");
        if (id == null) {
            return null;
        }

        final Optional<User> user = userRepository.findById(Long.valueOf(id));
        if (user.isEmpty()) {
            return null;
        }

        map.put("user", user.get());
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
        final Integer user_id = (Integer) map.get("user_id");
        if (user_id == null) {
            return null;
        }

        final Optional<User> user = userRepository.findById(Long.valueOf(user_id));
        if (user.isEmpty()) {
            return null;
        }

        map.put("user", user.get());
        final Board updateBoard = new Board(map);
        final Optional<Board> savedBoard = boardRepository.findById(id);
        if (savedBoard.isEmpty()) {
            return null;
        }

        savedBoard.get().setTitle(updateBoard.getTitle());
        savedBoard.get().setBody(updateBoard.getBody());
        savedBoard.get().setUser(updateBoard.getUser());

        return boardRepository.save(savedBoard.get());
    }
}
