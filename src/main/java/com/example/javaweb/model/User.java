package com.example.javaweb.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;
    private String name = null;

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
