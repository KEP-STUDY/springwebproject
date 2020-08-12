package com.example.demo.service;

import com.example.demo.domain.BoardVO;
import com.example.demo.domain.Criteria;

import java.util.List;

public interface BoardService {
    void register(BoardVO board);
    BoardVO get(Long bno);
    boolean modify(BoardVO board);
    boolean remove(Long bno);
    List<BoardVO> getList(Criteria cri);
    int getTotal(Criteria cri);
}
