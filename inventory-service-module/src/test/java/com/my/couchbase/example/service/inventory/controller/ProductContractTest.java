package com.my.couchbase.example.service.inventory.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


import com.github.couchversion.CouchVersion;
import com.my.couchbase.example.service.inventory.model.Product;
import com.my.couchbase.example.service.inventory.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;

public abstract class ProductContractTest extends AbstractContractTest {

    @MockBean
    private ProductService productService;

    @MockBean
    private CouchVersion couchVersions;

    @BeforeEach
    void setup() {
        Product product = Product.builder().id("123eff67-e89b-12d3-a456-426655440001")
            .name("product1")
            .description("description1")
            .quantity(1)
            .build();
        when(productService.create(any(Product.class))).thenReturn(Mono.just(product));
    }
}
