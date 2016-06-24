package io.client;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Piotr on 24.06.2016.
 */

@Service
public class ProxyService {

    private RestTemplate restTemplate = new RestTemplate();
    private String URL = "http://localhost:8181/hello";


    @HystrixCommand(fallbackMethod = "fallBack")
    public String proxy() {
        String body = restTemplate.getForEntity(URL, String.class).getBody();
        return body;
    }

    private String fallBack() {
        return "FallBack";
    }

}
