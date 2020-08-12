package com.example.demo.domain;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// page 517
@Getter
@Setter
public class AttachFileDTO {
    private String fileName;
    private String uploadPath;
    private String uuid;
    private boolean image;
}
