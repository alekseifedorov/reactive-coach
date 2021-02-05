package com.my.couchbase.example.service.inventory.configuration;

import org.mapstruct.Builder;
import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

@MapperConfig(
        builder = @Builder(disableBuilder = true),
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = "spring"
)
public class MappingConfiguration {
}
