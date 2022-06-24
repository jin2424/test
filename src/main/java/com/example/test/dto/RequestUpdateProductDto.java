package com.example.test.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class RequestUpdateProductDto {
    private int price;

    @Builder
    public RequestUpdateProductDto(int price) {
        this.price = price;
    }
}