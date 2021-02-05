package com.my.couchbase.example.service.inventory.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {

    private String id;
    private String name;
    private String description;
    private Integer quantity;
}
