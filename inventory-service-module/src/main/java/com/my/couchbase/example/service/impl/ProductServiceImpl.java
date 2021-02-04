package com.my.couchbase.example.service.impl;

import com.my.couchbase.example.doc.ProductDoc;
import com.my.couchbase.example.dto.Product;
import com.my.couchbase.example.mapping.ProductMapper;
import com.my.couchbase.example.repository.ProductRepository;
import com.my.couchbase.example.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    private final ProductMapper mapper;

    @Override
    public Mono<ProductDoc> findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public Mono<Product> create(Product product) {
        ProductDoc doc = mapper.fromDto(product);
        return productRepository.save(doc)
            .log()
            .map(mapper::toDto);
    }

}
