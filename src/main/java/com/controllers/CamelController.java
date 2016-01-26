package com.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Piotr on 26.01.2016.
 */
@RestController
public class CamelController {

    @RequestMapping(value = "camel")
    public ResponseEntity<String> getName() {


        return null;
    }

}
