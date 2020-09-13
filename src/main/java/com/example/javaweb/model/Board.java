package com.example.javaweb.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.HashMap;

@Entity
public class Board {

    private Long id = null;
    private String title = null;
    private String body = null;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }
    public String getBody() {
        return body;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public Board() {}

    public Board(Long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Board(HashMap<String, Object> map) {
        if (map.get("id") != null) {
            this.id = (Long) map.get("id");
        }
        if (map.get("title") != null) {
            this.title = (String) map.get("title");
        }
        if (map.get("body") !=  null) {
            this.body = (String) map.get("body");
        }
    }
}
