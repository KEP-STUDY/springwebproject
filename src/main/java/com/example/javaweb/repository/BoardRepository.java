package com.example.javaweb.repository;

import com.example.javaweb.model.Board;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public class BoardRepository {
    private ArrayList<Board> boards = new ArrayList<>();

    public int insert(Board board) {
        if (board == null) {
            return -1;
        }

        int newId = 1;
        if (boards.size() != 0) {
            newId = boards.get(boards.size() - 1).getId() + 1;
        }

        final Board newBoard = new Board
                .Builder(board)
                .id(newId)
                .build();
        boards.add(newBoard);
        return newId;
    }

    public Board find(int id) {
        return boards
                .stream()
                .filter(board -> board.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public int size() {
        return boards.size();
    }

    public boolean delete(int id) {
        final Board board = find(id);
        if (board == null) {
            return false;
        }

        boards.remove(board);
        return true;
    }

    public Board update(int id, Board updateBoard) {
        Board board = find(id);
        if (board == null) {
            return null;
        }

        Board.Builder builder = new Board.Builder(board);
        if (updateBoard.getTitle() != null) {
            builder.title(updateBoard.getTitle());
        }
        if (updateBoard.getBody() != null) {
            builder.body(updateBoard.getBody());
        }
        Board newBoard = builder.build();

        boards.replaceAll((oldBoard) -> {
            if (oldBoard.getId() != id) {
                return oldBoard;
            } else {
                return newBoard;
            }
        });

        return newBoard;
    }
}
