package com.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Piotr on 27.12.2015.
 */
@Configuration
public class RestClientFactory {

    @Bean
    public RestTemplate createRestTemplate() {
        System.out.println("Creating bean RestTemplate!");
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        return restTemplate;
    }
}
