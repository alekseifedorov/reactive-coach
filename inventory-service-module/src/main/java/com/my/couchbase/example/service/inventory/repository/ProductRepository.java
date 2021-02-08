package com.my.couchbase.example.service.inventory.repository;

import com.my.couchbase.example.service.inventory.model.ProductDoc;
import org.springframework.data.repository.reactive.ReactiveSortingRepository;

public interface ProductRepository extends ReactiveSortingRepository<ProductDoc, String> {

}
