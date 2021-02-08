package com.my.couchbase.example.service.inventory.configuration;

import com.github.couchversion.CouchVersion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties({CouchbaseSetting.class})
public class AppConfiguration {
    @Autowired
    private CouchbaseConfig couchbaseConfig;

    @Autowired
    private ApplicationContext context;

    @Bean
    public CouchVersion couchVersions() {
        CouchVersion runner = new CouchVersion(couchbaseConfig.getConnectionString(),
            couchbaseConfig.getBucketName(), couchbaseConfig.getUserName(), couchbaseConfig.getPassword());
        runner.setApplicationContext(context);
        runner.setChangeLogsScanPackage("com.my.couchbase.example.service.inventory.migration");
        return runner;
    }
}

