package com.example.test.service;

import com.example.test.dto.RequestCreateProductDto;
import com.example.test.dto.RequestUpdateProductDto;
import com.example.test.dto.ResponseProductDto;

public interface ProductService {
    long saveProduct(RequestCreateProductDto requestCreateProductDto);
    ResponseProductDto findProduct(Long id);
    long removeProduct(Long id);
    long modifyProduct(Long id, RequestUpdateProductDto requestUpdateProductDTO);
}
