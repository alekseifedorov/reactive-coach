package com.my.couchbase.example.service;

import com.my.couchbase.example.doc.ProductDoc;
import com.my.couchbase.example.dto.Product;
import reactor.core.publisher.Mono;

public interface ProductService {
    Mono<ProductDoc> findById(String id);

    Mono<Product> create(Product product);
}
