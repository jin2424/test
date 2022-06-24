package com.example.test.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ResponseProductDto {
    private String ProductName;
    private int ProductQty;
    private int ProductPrice;

    @Builder
    public ResponseProductDto(String name, int qty, int price) {
        this.ProductName = name;
        this.ProductQty = qty;
        this.ProductPrice = price;
    }
}