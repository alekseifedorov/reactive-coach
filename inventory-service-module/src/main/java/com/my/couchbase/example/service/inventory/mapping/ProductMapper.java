package com.my.couchbase.example.service.inventory.mapping;

import com.my.couchbase.example.service.inventory.configuration.MappingConfiguration;
import com.my.couchbase.example.service.inventory.doc.ProductDoc;
import com.my.couchbase.example.service.inventory.dto.Product;
import org.mapstruct.Mapper;

@Mapper(config = MappingConfiguration.class)
public interface ProductMapper {

    ProductDoc fromDto(Product dto);

    Product toDto(ProductDoc doc);
}