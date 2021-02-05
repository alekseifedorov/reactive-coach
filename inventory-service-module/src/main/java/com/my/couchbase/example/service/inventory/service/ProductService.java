package com.my.couchbase.example.service.inventory.service;

import com.my.couchbase.example.service.inventory.doc.ProductDoc;
import com.my.couchbase.example.service.inventory.dto.Product;
import reactor.core.publisher.Mono;

public interface ProductService {
    Mono<ProductDoc> findById(String id);

    Mono<Product> create(Product product);
}
