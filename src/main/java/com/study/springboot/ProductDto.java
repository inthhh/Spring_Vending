package com.study.springboot;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ProductDto {
    private String name; // 상품명
    private int price; // 가격
    private LocalDate limit_date; // 유통기한
}
