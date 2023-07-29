package com.yflash.tech.SampleAPI.controller;

import com.yflash.tech.SampleAPI.model.in.DeleteUserRequest;
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

    @DeleteMapping(value = "/delete-user", produces = "text/plain", consumes = "application/json")
    public ResponseEntity<String> deleteUserDetails(@RequestBody DeleteUserRequest userRequest) {
        String serviceResponse = userService.deleteUserDetails(userRequest.getId());
        if(serviceResponse == null)
            return new ResponseEntity<>("Data doesn't exists for this id", HttpStatus.NOT_FOUND);
        return new ResponseEntity<>("Data for id " + serviceResponse + "is deleted successfully!", HttpStatus.OK);
    }

}
