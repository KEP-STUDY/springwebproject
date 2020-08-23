package com.example.javaweb.model;

import java.util.HashMap;

public class Board {
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    private int id;
    private String title;
    private String body;

    public static class Builder {
        private int id = -1;
        private String title = null;
        private String body = null;

        public Builder(Board board) {
            id = board.id;
            title = board.title;
            body = board.body;
        }

        public Builder id(int id) {
            this.id = id;
            return this;
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder body(String body) {
            this.body = body;
            return this;
        }

        public Builder() {}

        public Builder(HashMap<String, Object> map) {
            if (map.get("title") instanceof String) {
                this.title = (String) map.get("title");
            }

            if (map.get("body") instanceof String) {
                this.body = (String) map.get("body");
            }
        }

        public Board build() {
            return new Board(this);
        }
    }

    private Board(Builder builder) {
        id = builder.id;
        title = builder.title;
        body = builder.body;
    }
}
