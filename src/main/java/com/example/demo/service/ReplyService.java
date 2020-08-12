package com.example.demo.service;

import com.example.demo.domain.Criteria;
import com.example.demo.domain.ReplyPageDTO;
import com.example.demo.domain.ReplyVO;

import java.util.List;

public interface ReplyService {
    int register(ReplyVO vo);
    ReplyVO get(Long rno);
    int modify(ReplyVO vo);
    int remove(Long rno);
    List<ReplyVO> getList(Criteria cri, Long bno);
    ReplyPageDTO getListPage(Criteria cri, Long bno);
}
