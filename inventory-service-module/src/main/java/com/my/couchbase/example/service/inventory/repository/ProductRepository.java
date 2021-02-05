package com.my.couchbase.example.service.inventory.repository;

import com.my.couchbase.example.service.inventory.doc.ProductDoc;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository extends ReactiveCrudRepository<ProductDoc, String> {

}
