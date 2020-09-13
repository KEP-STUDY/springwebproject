package com.example.javaweb.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    public String getName() {
        return name;
    }

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public User() {}

    public void setName(String name) {
        this.name = name;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getId() {
        return id;
    }
}
