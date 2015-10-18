package com.controllers;

import com.model.User;
import com.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Piotr on 2015-10-10.
 */
@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "register")
    @ResponseBody
    public ResponseEntity<User> register(@RequestBody User user) {
        if (!exist(user)) {
            User createdUser = userRepository.save(user);
            return new ResponseEntity<User>(createdUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<User>(user, HttpStatus.CONFLICT);

        }
    }

    private boolean exist(User user) {
        return userRepository.exists(user.getName());
    }

}
