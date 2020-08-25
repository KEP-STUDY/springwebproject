package com.example.javaweb.model;

import lombok.Data;

@Data
public class Board {
    public Long id;
    public String subject;
    public String content;
    public String writer;
}
