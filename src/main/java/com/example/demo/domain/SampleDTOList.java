package com.example.demo.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class SampleDTOList {
    private List<SampleDTO> list;
    public SampleDTOList() {
        list = new ArrayList<>();
    }
}
