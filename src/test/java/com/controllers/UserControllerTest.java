package com.controllers;

import com.app.Application;
import com.model.User;
import com.repository.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.internal.matchers.apachecommons.ReflectionEquals;
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
import static org.junit.Assert.assertThat;

/**
 * Created by Piotr on 28.01.2016.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest("server.port=0")
public class UserControllerTest {

    @Value("${local.server.port}")
    private int port;

    private URL base;

    private RestTemplate restTemplate;

    @InjectMocks
    private UserController userController;

    @Mock
    private UserRepository userRepository;

    private User user;

    @Before
    public void setUp() throws MalformedURLException {
        this.base = new URL("http://localhost:" + port + "/");
        restTemplate = new TestRestTemplate();
        user = new User("John", "Smith");
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void registerUserTest() {

        //given
        Mockito.when(userRepository.save(user)).thenReturn(user);
        User expectedUser = new User("John", "Smith");


        //when
        ResponseEntity<User> response = restTemplate.postForEntity("http://localhost:" + port + "/register", user, User.class);
        User returnedUser = response.getBody();

        //then
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertThat(expectedUser, new ReflectionEquals(returnedUser));
    }

}