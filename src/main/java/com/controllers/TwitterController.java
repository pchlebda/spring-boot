package com.controllers;

import com.service.TwitterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Piotr on 02.01.2016.
 */
@RestController
public class TwitterController {

    @Autowired
    private TwitterService twitterService;

    @RequestMapping(value = "tweet")
    public ResponseEntity<String> getName() {
        String applicationName = twitterService.getApplicationName();
        return new ResponseEntity<String>(applicationName, HttpStatus.OK);
    }

}
