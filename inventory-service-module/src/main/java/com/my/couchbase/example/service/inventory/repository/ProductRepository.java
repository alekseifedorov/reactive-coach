package com.my.couchbase.example.service.inventory.repository;

import com.my.couchbase.example.service.inventory.model.Product;
import org.springframework.data.couchbase.repository.Query;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;
import reactor.core.publisher.Flux;

public interface ProductRepository extends ReactiveSortingRepository<Product, String> {
    @Query("#{#n1ql.selectEntity} where #{#n1ql.filter} LIMIT $1 OFFSET $2")
    Flux<Product> findAll(Integer limit, Integer offset);
}
