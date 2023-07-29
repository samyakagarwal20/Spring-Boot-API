package com.yflash.tech.SampleAPI.controller;

import com.yflash.tech.SampleAPI.model.in.PutUserRequest;
import com.yflash.tech.SampleAPI.model.out.User;
import com.yflash.tech.SampleAPI.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    private static final Logger LOGGER = LogManager.getLogger(UserController.class);

    @PutMapping(value = "/update-user-details", produces = "application/json", consumes = "application/json")
    public ResponseEntity<User> updateUserDetails(@RequestBody PutUserRequest userRequest) {
        return new ResponseEntity<>(userService.updateUserDetails(userRequest), HttpStatus.OK);
    }

}
