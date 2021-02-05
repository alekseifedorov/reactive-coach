package com.my.couchbase.example.service.inventory.testcontainers;

import com.github.dockerjava.api.model.Capability;
import lombok.extern.slf4j.Slf4j;
import org.testcontainers.couchbase.BucketDefinition;
import org.testcontainers.couchbase.CouchbaseContainer;
import org.testcontainers.couchbase.CouchbaseService;

@Slf4j
public class CustomCouchbaseContainer extends CouchbaseContainer {

    private static final String DOCKER_IMAGE = "couchbase/server:6.5.1";
    private static final String USERNAME = "admin";
    private static final String PASSWORD = "password";
    private static final CouchbaseService[] SERVICES = {
        CouchbaseService.INDEX
        , CouchbaseService.KV
        , CouchbaseService.QUERY
        , CouchbaseService.SEARCH};
    private static final String BUCKET = "users";

    public CustomCouchbaseContainer(final String dockerImageName) {
        super(dockerImageName);
    }

    private static CustomCouchbaseContainer container;

    public static CustomCouchbaseContainer getInstance() {
        BucketDefinition bucketDefinition = new BucketDefinition(BUCKET).withPrimaryIndex(true);
        if (container == null) {
            container = (CustomCouchbaseContainer) new CustomCouchbaseContainer(DOCKER_IMAGE)
                .withBucket(bucketDefinition)
                .withEnabledServices(SERVICES)
                .withCredentials(USERNAME, PASSWORD)
                .withCreateContainerCmdModifier(cmd -> cmd.getHostConfig().withCapAdd(Capability.NET_ADMIN));
        }
        return container;
    }

    @Override
    public void start() {
        super.start();

        Integer mappedHttpPort = container.getBootstrapHttpDirectPort();
        Integer mappedCarrierPort = container.getBootstrapCarrierDirectPort();
        String host = container.getHost();

        System.setProperty("com.couchbase.bootstrapHttpDirectPort", String.valueOf(mappedHttpPort));
        System.setProperty("com.couchbase.bootstrapCarrierDirectPort", String.valueOf(mappedCarrierPort));
        System.setProperty("couchbase.hostname", host + ":" + mappedCarrierPort);
    }

    @Override
    public void stop() {
        // don't stop container between executions
    }
}
