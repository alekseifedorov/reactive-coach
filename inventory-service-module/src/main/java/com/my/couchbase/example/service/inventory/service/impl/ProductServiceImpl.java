package com.my.couchbase.example.service.inventory.service.impl;

import com.my.couchbase.example.service.inventory.mapping.ProductMapper;
import com.my.couchbase.example.service.inventory.model.Product;
import com.my.couchbase.example.service.inventory.repository.ProductRepository;
import com.my.couchbase.example.service.inventory.service.ProductService;
import org.springframework.data.domain.Pageable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

    private final ProductMapper mapper;

    @Override
    public Mono<Product> findAllByIdNotNullOrderByIdAsc(String id) {
        return productRepository.findById(id);
    }

    @Override
    public Mono<Product> create(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Flux<Product> findAllByIdNotNullOrderByIdAsc(Pageable page) {
        return productRepository.findAll(page.getPageSize(), (int) page.getOffset());
    }

}
