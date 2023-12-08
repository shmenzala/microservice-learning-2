package com.pe.sh.microservicelearning;

import com.pe.sh.microservicelearning.repository.ProductosRepository;
import org.assertj.core.api.AssertionsForClassTypes;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

//@SpringBootTest
//@Testcontainers
class ProductServiceApplicationTests {

//    @Container
//    @ServiceConnection
//    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:6.0.4");
//    
//    @Autowired
//    ProductosRepository productRepository;
//    
    @Test
    void contextLoads() {
//        AssertionsForClassTypes.assertThat(mongoDBContainer.isCreated()).isTrue();
//        AssertionsForClassTypes.assertThat(mongoDBContainer.isRunning()).isTrue();
    }

}
