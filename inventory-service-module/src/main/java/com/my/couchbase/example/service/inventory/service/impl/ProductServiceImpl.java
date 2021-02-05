package com.my.couchbase.example.service.inventory.service.impl;

import com.my.couchbase.example.service.inventory.doc.ProductDoc;
import com.my.couchbase.example.service.inventory.dto.Product;
import com.my.couchbase.example.service.inventory.mapping.ProductMapper;
import com.my.couchbase.example.service.inventory.repository.ProductRepository;
import com.my.couchbase.example.service.inventory.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {


    private final ProductRepository productRepository;

  //  private final ProductMapper mapper;

    @Override
    public Mono<ProductDoc> findById(String id) {
        return productRepository.findById(id);
    }

    @Override
    public Mono<Product> create(Product product) {
        return Mono.just(Product.builder().id("dfgsdfgdf").name("zxczxc").build());
//        ProductDoc doc = mapper.fromDto(product);
//        return productRepository.save(doc)
//            .log()
//            .map(mapper::toDto);
    }

}
