package com.example.javaweb.repository;

import com.example.javaweb.model.Board;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BoardRepositoryTest {
    private BoardRepository boardRepository;

    @BeforeEach
    void setUp() {
        this.boardRepository = new BoardRepository();
    }

    @Test
    void insertBoard() {
        final Board board = new Board.Builder().build();

        assertNotEquals(-1, boardRepository.insert(board));
        assertEquals(1, boardRepository.size());
    }

    @Test
    void firstBoardIdIs1() {
        final Board board = new Board.Builder().build();
        assertEquals(1, boardRepository.insert(board));
    }

    @Test
    void cannotHaveSpecificId() {
        final int specificId = 9999;
        final Board board = new Board.Builder().id(specificId).build();
        assertNotEquals(specificId, boardRepository.insert(board));
    }

    @Test
    void cannotInsertNullBoard() {
        assertEquals(-1, boardRepository.insert(null));
        assertEquals(0, boardRepository.size());
    }

    @Test
    void findBoard() {
        final String title = "title";
        final String body = "body";
        final Board board = new Board.Builder().title(title).body(body).build();
        final int id = boardRepository.insert(board);

        final Board foundedBoard = boardRepository.find(id);
        assertEquals(id, foundedBoard.getId());
        assertEquals(board.getTitle(), foundedBoard.getTitle());
        assertEquals(board.getBody(), foundedBoard.getBody());
    }

    @Test
    void returnNullIfWrongId() {
        final int wrongId = -9999;
        final Board board = boardRepository.find(wrongId);
        assertNull(board);
    }

    @Test
    void deleteBoard() {
        final String title = "title";
        final String body = "body";
        final Board board = new Board.Builder().title(title).body(body).build();
        final int id = boardRepository.insert(board);

        assertTrue(boardRepository.delete(id));
        assertNull(boardRepository.find(id));
        assertEquals(0, boardRepository.size());
    }

    @Test
    void cannotDeleteWrongId() {
        final int wrongId = -9999;
        assertFalse(boardRepository.delete(wrongId));
    }

    @Test
    void updateBoard() {
        final String title = "title";
        final String body = "body";
        final Board board = new Board.Builder().title(title).body(body).build();
        final int id = boardRepository.insert(board);

        final String newTitle = "update title";
        final String newBody = "update body";
        final Board newBoard = new Board.Builder().title(newTitle).body(newBody).build();

        final Board updatedBoard = boardRepository.update(id, newBoard);

        assertNotEquals(title, updatedBoard.getTitle());
        assertEquals(newTitle, updatedBoard.getTitle());
        assertNotEquals(body, updatedBoard.getBody());
        assertEquals(newBody, updatedBoard.getBody());
    }

    @Test
    void cannotUpdateWrongId() {
        final int wrongId = -9999;
        final String title = "update title";
        final String body = "update body";
        final Board board = new Board.Builder().title(title).body(body).build();

        final Board updatedBoard = boardRepository.update(wrongId, board);
        assertNull(updatedBoard);
    }
}
