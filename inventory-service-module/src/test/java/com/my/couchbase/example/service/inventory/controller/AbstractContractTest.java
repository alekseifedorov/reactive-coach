package com.my.couchbase.example.service.inventory.controller;

import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(//classes = AbstractContractTest.ContractTestConfig.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    properties = "server.port=0")
public abstract class AbstractContractTest {

    @LocalServerPort
    int port;

    @BeforeEach
    void setupContext() {
        RestAssured.baseURI = "http://localhost:" + port;
    }

//    exclude CouchbaseConfig and AppConfiguration not to start couchbase client
//    @Configuration
//    @ComponentScan(basePackageClasses = InventoryServiceApplication.class)
//    static class ContractTestConfig {
//    }

}
