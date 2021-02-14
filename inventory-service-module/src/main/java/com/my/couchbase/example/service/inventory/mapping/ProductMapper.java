package com.my.couchbase.example.service.inventory.mapping;

import com.my.couchbase.example.service.inventory.configuration.MappingConfiguration;
import com.my.couchbase.example.service.inventory.dto.ProductDto;
import com.my.couchbase.example.service.inventory.model.Product;
import org.mapstruct.Mapper;

@Mapper(config = MappingConfiguration.class)
public interface ProductMapper {

    Product fromDto(ProductDto dto);

    ProductDto toDto(Product doc);
}