package com.example.demo.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Ticket {
    private int tno;
    private String owner;
    private String grade;
}
