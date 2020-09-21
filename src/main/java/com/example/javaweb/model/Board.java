package com.example.javaweb.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;

@Entity
@Table(name = "boards")
public class Board implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private Long id = null;
    @JsonProperty
    private String title = null;
    @JsonProperty
    private String body = null;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    @JsonIgnoreProperties(value = {"applications", "hibernateLazyInitializer"})
    private User user;

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

    public Board(Long id, String title, String body, User user) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.user = user;
    }

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
        if (map.get("user") != null) {
            this.user = (User) map.get("user");
        }
    }
}
