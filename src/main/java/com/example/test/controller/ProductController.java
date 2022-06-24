package com.example.test.controller;

import com.example.test.common.ApiResponse;
import com.example.test.dto.RequestCreateProductDto;
import com.example.test.dto.RequestUpdateProductDto;
import com.example.test.dto.ResponseProductDto;
import com.example.test.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping("/api/create")
    public ApiResponse createProduct(@RequestBody RequestCreateProductDto requestCreateProductDto) {
        long retId = productService.saveProduct(requestCreateProductDto);
        return ApiResponse.success("result", retId);
    }
    @GetMapping("/api/read/{id}")
    public ApiResponse readMember(@PathVariable Long id){
        ResponseProductDto responseProductDto = productService.findProduct(id);
        return ApiResponse.success("result",responseProductDto);
    }
    @PutMapping("/api/update/{id}")
    public ApiResponse updateProduct(@PathVariable Long id, @RequestBody RequestUpdateProductDto requestUpdateProductDto){
        long retId = productService.modifyProduct(id, requestUpdateProductDto);
        return ApiResponse.success("result",retId);
    }
    @DeleteMapping("/api/delete/{id}")
    public ApiResponse deleteProduct(@PathVariable Long id){
        long retId = productService.removeProduct(id);
        return ApiResponse.success("result", retId);
    }
}
