package com.yflash.tech.SampleAPI.controller;

import com.yflash.tech.SampleAPI.model.in.PostUserRequest;
import com.yflash.tech.SampleAPI.model.out.User;
import com.yflash.tech.SampleAPI.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    private static final Logger LOGGER = LogManager.getLogger(UserController.class);
    @PostMapping(value = "/add-user", produces = "application/json", consumes = "application/json")
    public ResponseEntity<User> addUserDetails(@RequestBody PostUserRequest userRequest) {
        return new ResponseEntity<>(userService.addUserDetails(userRequest), HttpStatus.CREATED);
    }

}
