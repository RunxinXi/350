package com.example.cms.controller.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDto {

    private Long pid;
    private String pname;
    private int price;
    private Long cid;
    private int num;
    private int total;
}
