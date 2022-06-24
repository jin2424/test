package com.example.test.domain;

import com.example.test.dto.RequestUpdateProductDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // get 함수를 일괄적으로 만듬
@NoArgsConstructor // 기본생성자를 대신 생성
@Entity // 테이블임을 나타냄
public class Product extends TimeStamped {
    @JsonIgnore // 응답값에 보이지 않게 해줌
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ID가 자동으로 생성 및 증가
    private Long id;

    @NotNull
    private String productName;

    @NotNull
    private int productQty;

    @NotNull
    private int productPrice;

    @Builder
    public Product(String name, int qty, int price) {
        this.productName = name;
        this.productQty = qty;
        this.productPrice = price;
    }

    public void updateProduct(RequestUpdateProductDto requestUpdateProductDto) {
        this.productPrice =requestUpdateProductDto.getPrice();
    }
}
