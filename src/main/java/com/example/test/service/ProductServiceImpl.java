package com.example.test.service;

import com.example.test.domain.Product;
import com.example.test.dto.RequestCreateProductDto;
import com.example.test.dto.RequestUpdateProductDto;
import com.example.test.dto.ResponseProductDto;
import com.example.test.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;

    @Override
    public long saveProduct(RequestCreateProductDto requestCreateProductDto) {
        Product product = Product.builder()
                .name(requestCreateProductDto.getName())
                .qty(requestCreateProductDto.getQty())
                .price(requestCreateProductDto.getPrice())
                .build();
        return productRepository.save(product).getId();
    }

    @Override
    public ResponseProductDto findProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(
                () -> new NullPointerException("상품이 존재하지 않습니다.")
        );
        return ResponseProductDto.builder()
                .name(product.getProductName())
                .qty(product.getProductQty())
                .price(product.getProductPrice())
                .build();
    }
    @Override
    public long modifyProduct(Long id, RequestUpdateProductDto requestUpdateProductDto) {
         Product product = productRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("상품이 존재하지 않습니다.")
        );
        product.updateProduct(requestUpdateProductDto);
        return productRepository.save(product).getId();
    }
    @Override
    public long removeProduct(Long id) {
        productRepository.deleteById(id);
        return id;
    }

}
