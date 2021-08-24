package com.codewithcup.usermanage.controller;

import com.codewithcup.usermanage.entity.User;
import com.codewithcup.usermanage.payload.UserPayload;
import com.codewithcup.usermanage.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    UserService userService;

    @GetMapping("/name/{fname}")
    public ResponseEntity<String> getMessage(@PathVariable String fname) {
        logger.info("Welcome " + fname);
        return new ResponseEntity<>("Welcome to " + fname.toUpperCase(), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserPayload userPayload) {
        logger.info("Create User " + userPayload);
        try {
            userService.saveUser(userPayload);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("User Created Successfully", HttpStatus.OK);
    }

    @PutMapping("/update/{userId}")
    public ResponseEntity<String> updateUser(@PathVariable Long userId) {
        logger.info("Updated User " + userId);
        return new ResponseEntity<>("User Updated  Successfully", HttpStatus.OK);
    }

    @DeleteMapping("/delete/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable Long userId) {
        logger.info("User deleted " + userId);
        return new ResponseEntity<>("User Deleted  Successfully", HttpStatus.OK);
    }


}
