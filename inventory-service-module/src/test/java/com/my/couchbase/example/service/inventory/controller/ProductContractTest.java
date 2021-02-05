package com.my.couchbase.example.service.inventory.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


import com.my.couchbase.example.service.inventory.dto.Product;
import com.my.couchbase.example.service.inventory.service.ProductService;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Mono;

public abstract class ProductContractTest extends AbstractContractTest {

    @MockBean
    private ProductService productService;

    @BeforeEach
    void setup() {
        Product product = Product.builder().id("123eff67-e89b-12d3-a456-426655440001")
            .name("product1")
            .description("description1")
            .quantity(1)
            .build();
        when(productService.create(any(Product.class))).thenReturn(Mono.just(product));
    }

//    @EnableAutoConfiguration
//    @Configuration
//    static class ContractTestConfig {
//    }
}
