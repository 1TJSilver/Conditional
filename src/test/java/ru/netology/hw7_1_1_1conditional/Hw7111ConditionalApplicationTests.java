package ru.netology.hw7_1_1_1conditional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.testcontainers.containers.GenericContainer;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Hw7111ConditionalApplicationTests {
    @Autowired
    TestRestTemplate restTemplate;

    private static final GenericContainer<?> devCon = new GenericContainer<>("devapp:latest")
            .withExposedPorts(8080);

    private static final GenericContainer<?> prodCon = new GenericContainer<>("prodapp:latest")
            .withExposedPorts(8080);

    @Test
    void contextDevLoads() {
        String excepted = "Current profile is dev";

        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:"
                + devCon.getMappedPort(8080), String.class);
        System.out.println(entity.getBody());

        assertEquals(excepted, entity.getBody());
    }

    @Test
    void contextProdLoads() {
        String excepted = "Current profile is production";

        ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:"
                + prodCon.getMappedPort(8080), String.class);

        assertEquals(excepted, entity.getBody());
    }

    @BeforeAll
    public static void setUpp(){
        devCon.start();
        prodCon.start();
    }

}
