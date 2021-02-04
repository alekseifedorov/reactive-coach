package com.my.couchbase.example.service.inventory;

import com.my.couchbase.example.InventoryServiceApplication;
import com.my.couchbase.example.configuration.AppConfiguration;
import com.my.couchbase.example.configuration.CouchbaseConfig;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@EnableAutoConfiguration(exclude = {
    SecurityAutoConfiguration.class
})
@Import({
    AppConfiguration.class,
    CouchbaseConfig.class
})
@ComponentScan(basePackageClasses = InventoryServiceApplication.class)
public class TestConfig {
}
