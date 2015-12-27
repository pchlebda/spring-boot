package com.service;

import com.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Piotr on 23.12.2015.
 */
@Service
public class SessionService {

    @Value("${url}")
    private String serverUrl;

    @Autowired
    private RestTemplate restTemplate;

    public String createSession() {
        Session session = restTemplate.postForObject(serverUrl, createRequest(), Session.class);
        return session.getAccessToken();
    }

    private HttpEntity<String> createRequest() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        return new HttpEntity<>(getCredential(), headers);
    }

    private String getCredential() {
        return "grant_type=client_credentials&client_id=145227&client_secret=12f071174cb7eb79d4aac5bc2f07563f";
    }
}
