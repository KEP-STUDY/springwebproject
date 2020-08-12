package com.example.demo.mapper;

import com.example.demo.domain.BoardVO;
import com.example.demo.domain.Criteria;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BoardMapper {
//    @Select("select * from tbl_board where bno > 0")
    List<BoardVO> getList();
    List<BoardVO> getListWithPaging(Criteria cri);
    void insert(BoardVO board);
    void insertSelectKey(BoardVO board);
    BoardVO read(Long bno);
    int delete(Long bno);
    int update(BoardVO board);
    int getTotalCount(Criteria cri);
    void updateReplyCnt(@Param("bno") Long bno, @Param("amount") int amount);
}
