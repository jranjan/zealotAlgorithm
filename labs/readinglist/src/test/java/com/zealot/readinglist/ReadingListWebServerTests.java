package com.zealot.readinglist;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = ReadingListApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ReadingListWebServerTests {
    @LocalServerPort
    private int port;
    @Test
    public void pageNotFound() {
        try {
            RestTemplate rest = new RestTemplate();
            String url = "http://localhost:" + port + "/bogusPage";
            rest.getForObject(url, String.class);
        } catch(Exception e) {
            assertNotNull(e);
        }
    }
}