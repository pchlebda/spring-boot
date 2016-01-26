package com.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.impl.TwitterTemplate;

/**
 * Created by Piotr on 02.01.2016.
 */
@Configuration
@PropertySource("classpath:twitter.properties")
public class TwitterServiceFactory {

    @Value("${twitter.account.name}")
    private String accountName;

    @Value("${twitter.consumer.key}")
    private String consumerKey;

    @Value("${twitter.consumer.secret.key}")
    private String consumerSecret;

    @Value("${twitter.access.token}")
    private String accessToken;

    @Value("${twitter.access.secret.token}")
    private String accessTokenSecret;

    @Bean
    public Twitter createTwitter() {
        return new TwitterTemplate(getAppNamePrefix() + consumerKey, getAppNamePrefix() + consumerSecret, getAppNamePrefix() + accessToken, getAppNamePrefix() + accessTokenSecret);
    }

    private String getAppNamePrefix() {
        return "." + accountName;
    }

}
