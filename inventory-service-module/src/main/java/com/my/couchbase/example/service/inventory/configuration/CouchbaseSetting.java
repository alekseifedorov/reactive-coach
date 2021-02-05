package com.my.couchbase.example.service.inventory.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "couchbase")
public class CouchbaseSetting {

    private String hostname;

    private String bucketName;

    private String username;

    private String password;
}
