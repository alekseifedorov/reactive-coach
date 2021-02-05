package com.my.couchbase.example.service.inventory.configuration;

import com.my.couchbase.example.service.inventory.repository.CouchbaseRepositoryBasePackage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@EnableCouchbaseRepositories(basePackageClasses = CouchbaseRepositoryBasePackage.class)
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Autowired
    private CouchbaseSetting couchbaseSetting;

    @Override
    public String getConnectionString() {
        return couchbaseSetting.getHostname();
    }

    @Override
    public String getUserName() {
        return couchbaseSetting.getUsername();
    }

    @Override
    public String getPassword() {
        return couchbaseSetting.getPassword();
    }

    @Override
    public String getBucketName() {
        return couchbaseSetting.getBucketName();
    }

    @Override
    public String typeKey() {
        return "type";
    }
}
