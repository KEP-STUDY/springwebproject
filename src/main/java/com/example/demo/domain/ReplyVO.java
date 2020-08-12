package com.example.demo.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ReplyVO {
    private Long rno;
    private Long bno;
    private String reply;
    private String replyer;
    private Date replyDate;
    private Date updateDate;
}
