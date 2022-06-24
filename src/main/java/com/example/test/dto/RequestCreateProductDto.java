package com.example.test.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RequestCreateProductDto {

    private String name;
    private int qty;
    private int price;

    @Builder
    public RequestCreateProductDto(String name, int qty, int price) {
        this.name = name;
        this.qty = qty;
        this.price = price;
    }
}