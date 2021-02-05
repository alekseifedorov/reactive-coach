package com.my.couchbase.example.service.inventory.service.inventory;

import static org.mockito.Mockito.mock;


import com.my.couchbase.example.service.inventory.service.ProductService;
import com.my.couchbase.example.service.inventory.testcontainers.CustomCouchbaseContainer;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;
import org.testcontainers.couchbase.CouchbaseContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

@SpringBootTest(classes = {
    TestConfig.class
})
@Testcontainers
public abstract class IntegrationTestBase {

    @Container
    public static CouchbaseContainer couchbaseContainer = CustomCouchbaseContainer.getInstance();

    //    @Autowired
    //    protected WebApplicationContext context;
    //
    //    protected MockMvc mvc;

    @Autowired
    protected ProductService productService;

    @Autowired
    Environment environment;

    @BeforeEach
    void setup() {
        //        DefaultMockMvcBuilder builder = MockMvcBuilders
        //            .webAppContextSetup(context)
        //            .alwaysDo(MockMvcResultHandlers.print());
        //        mvc = builder.build();
    }

    protected void clearDatabase() {
    }
}
