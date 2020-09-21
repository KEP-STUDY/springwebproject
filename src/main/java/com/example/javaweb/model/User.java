package com.example.javaweb.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonProperty
    private Long id = null;
    @JsonProperty
    private String name = null;

    public User(Long id, String name, List<Board> boards) {
        this.id = id;
        this.name = name;
        this.boards = boards;
    }

    public List<Board> getBoards() {
        return boards;
    }

    public void setBoards(List<Board> boards) {
        this.boards = boards;
    }

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Board> boards;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {}

    public User(HashMap<String, Object> map) {
        if (map.get("id") != null) {
            this.id = (Long) map.get("id");
        }
        if (map.get("name") != null) {
            this.name = (String) map.get("name");
        }
    }
}
