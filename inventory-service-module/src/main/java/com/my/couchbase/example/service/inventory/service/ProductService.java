package com.my.couchbase.example.service.inventory.service;

import com.my.couchbase.example.service.inventory.model.Product;
import org.springframework.data.domain.Pageable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Mono<Product> findAllByIdNotNullOrderByIdAsc(String id);

    Mono<Product> create(Product product);

    Flux<Product> findAllByIdNotNullOrderByIdAsc(Pageable page);
}
