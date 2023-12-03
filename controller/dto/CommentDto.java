package com.example.cms.controller.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDto {
    private long uid;
    private long pid;
    private String detail;
    private boolean Edited;
}
