package com.example.javaweb.db;

import com.example.javaweb.model.Board;
import org.springframework.stereotype.Component;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class Repository {
    private Map<Long, Board> map = new HashMap<>();
    private Long idCount = 1L;

    public Board save(Board board) {
        map.put(idCount++, board);
        return board;
    }

    public Board update(Long id, Board board) {
        map.put(id, board);
        return board;
    }

    public Board get(Long id) {
        return map.get(id);
    }

    public void delete(Long id) {
        map.remove(id);
    }

    public List<Board> getAll() {
        return new ArrayList<>(map.values());
    }
}
