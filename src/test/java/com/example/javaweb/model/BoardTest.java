package com.example.javaweb.model;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BoardTest {

    @Test
    public void hasId() {
        int id = 0;

        Board.Builder builder = new Board.Builder();
        Board board = builder.id(id).build();

        assertEquals(board.getId(), id);
    }

    @Test
    public void hasTitle() {
        String title = "test title";

        Board.Builder builder = new Board.Builder();
        Board board = builder.title(title).build();

        assertEquals(board.getTitle(), title);
    }

    @Test
    public void hasBody() {
        String body = "test body";

        Board.Builder builder = new Board.Builder();
        Board board = builder.body(body).build();

        assertEquals(board.getBody(), body);
    }

    @Test
    public void hasIdAndTitleAndBody() {
        int id = 0;
        String title = "test title";
        String body = "test body";

        Board.Builder builder = new Board.Builder();
        Board board = builder.id(id).title(title).body(body).build();

        assertEquals(board.getId(), id);
        assertEquals(board.getTitle(), title);
        assertEquals(board.getBody(), body);
    }

    @Test
    public void createFromHashMap() {
        String title = "test title";
        String body = "test body";

        HashMap<String, Object> map = new HashMap<>();
        map.put("title", title);
        map.put("body", body);

        final Board.Builder builder = new Board.Builder(map);
        Board board = builder.build();

        assertEquals(board.getTitle(), title);
        assertEquals(board.getBody(), body);
    }
}
