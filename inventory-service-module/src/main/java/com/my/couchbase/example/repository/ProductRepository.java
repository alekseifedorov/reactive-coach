package com.my.couchbase.example.repository;

import com.my.couchbase.example.doc.ProductDoc;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface ProductRepository extends ReactiveCrudRepository<ProductDoc, String> {

}
