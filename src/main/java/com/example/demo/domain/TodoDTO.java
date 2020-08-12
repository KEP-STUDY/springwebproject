package com.example.demo.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
public class TodoDTO {
    private String title;
//    FIXME 이상하게 이거 안됨.
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dueDate;
}
