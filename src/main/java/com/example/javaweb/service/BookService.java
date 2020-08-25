package com.example.javaweb.service;

import com.example.javaweb.db.Repository;
import com.example.javaweb.model.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private Repository repository;

    public Board create(Board board) {
        return repository.save(board);
    }

    public void delete(Long id) {
        repository.delete(id);
    }

    public Board update(Long id, Board updateData) {
        Board updatedBoard =  repository.get(id);
        if (updateData.content != null) updatedBoard.content = updateData.content;
        if (updateData.subject != null) updatedBoard.subject = updateData.subject;
        if (updateData.writer != null) updatedBoard.writer = updateData.writer;
        return repository.update(id, updatedBoard);
    }

    public List<Board> selectAll() {
        return repository.getAll();
    }
}
