package com.my.couchbase.example.service.inventory.controller;

import com.my.couchbase.example.service.inventory.InventoryServiceApplication;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AbstractContractTest.ContractTestConfig.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    properties = "server.port=0")
public abstract class AbstractContractTest {

    @LocalServerPort
    int port;

    @BeforeEach
    void setupContext() {
        RestAssured.baseURI = "http://localhost:" + port;
    }

    @EnableAutoConfiguration
    @Configuration
    @ComponentScan(basePackageClasses = InventoryServiceApplication.class)
    static class ContractTestConfig {
    }
}
