package com.my.couchbase.example.controller;

import com.my.couchbase.example.dto.Product;
import com.my.couchbase.example.mapping.ProductMapper;
import com.my.couchbase.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;
    private final ProductMapper productMapper;

    @PostMapping("")
    Mono<Product> createProduct(@RequestBody Product product) {
        return productService.create(product);
    }

    @GetMapping(value = "/{productId}")
    Mono<Product> getProduct(@PathVariable String productId) {
        return productService.findById(productId)
            .map(productMapper::toDto);
    }

}
