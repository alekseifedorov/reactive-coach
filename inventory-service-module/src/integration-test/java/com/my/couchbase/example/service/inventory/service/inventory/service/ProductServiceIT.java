package com.my.couchbase.example.service.inventory.service.inventory.service;

import static org.assertj.core.api.Assertions.assertThat;

import com.my.couchbase.example.service.inventory.model.Product;
import com.my.couchbase.example.service.inventory.service.inventory.IntegrationTestBase;
import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import reactor.test.StepVerifier;

public class ProductServiceIT extends IntegrationTestBase {

    private Product product;

    @Test
    public void whenCreatingThenFind() throws IOException {
        productService.create(Product.builder().name("abcd").quantity(1).build())
            .as(StepVerifier::create)
            .assertNext(it -> {
                    assertThat(it).isNotNull();
                    product = it;
                }
            ).verifyComplete();


        productService.findAllByIdNotNullOrderByIdAsc(PageRequest.of(0, 1))
            .as(StepVerifier::create)
            .assertNext(it -> assertThat(it).isNotNull()
            ).verifyComplete();

        productService.findAllByIdNotNullOrderByIdAsc(product.getId())
            .as(StepVerifier::create)
            .assertNext(it -> {
                assertThat(it).isNotNull();
            }).verifyComplete();
    }
}
