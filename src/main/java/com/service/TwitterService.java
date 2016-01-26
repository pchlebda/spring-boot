package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.twitter.api.Twitter;
import org.springframework.social.twitter.api.UserList;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * Created by Piotr on 02.01.2016.
 */
@Component
public class TwitterService {

    @Autowired
    private Twitter twitter;

    public String getApplicationName() {
        return twitter.listOperations().getLists().stream().map(UserList::getFullName).collect(Collectors.joining());
    }

}
