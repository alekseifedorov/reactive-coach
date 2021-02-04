package com.my.couchbase.example.mapping;

import com.my.couchbase.example.configuration.MappingConfiguration;
import com.my.couchbase.example.doc.ProductDoc;
import com.my.couchbase.example.dto.Product;
import org.mapstruct.Mapper;

@Mapper(config = MappingConfiguration.class)
public interface ProductMapper {

    ProductDoc fromDto(Product dto);

    Product toDto(ProductDoc doc);
}