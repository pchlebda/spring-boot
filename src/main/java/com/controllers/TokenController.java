package com.controllers;

import com.service.SessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Piotr on 23.12.2015.
 */
@RestController
public class TokenController {

    @Autowired
    private SessionService sessionService;

    @RequestMapping(value = "token")
    @ResponseBody
    public ResponseEntity<String> createToken() {

        String token = sessionService.createSession();

        return new ResponseEntity<String>(token, HttpStatus.OK);
    }

}
