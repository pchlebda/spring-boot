package com.controllers;

import com.app.Application;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Piotr on 27.01.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port=0")
public class TokenControllerTest {

    @Value("${local.server.port}")
    private int port;

    private URL base;

    private RestTemplate restTemplate;

    @Before
    public void setUp() throws MalformedURLException {
        this.base = new URL("http://localhost:" + port + "/");
        restTemplate = new TestRestTemplate();
    }


    @Test
    public void testToken() {

        ResponseEntity<String> response = restTemplate.getForEntity(base.toString() + "token", String.class);
        String token = response.getBody();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(token);

    }
}