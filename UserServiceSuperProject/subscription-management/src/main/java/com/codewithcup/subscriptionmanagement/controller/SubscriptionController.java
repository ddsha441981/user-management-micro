package com.codewithcup.subscriptionmanagement.controller;

import com.codewithcup.subscriptionmanagement.payload.SubscriptionPayload;
import com.codewithcup.subscriptionmanagement.service.SubscriptionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subscription/user/")
public class SubscriptionController {
    private static final Logger logger = LoggerFactory.getLogger(SubscriptionController.class);

    @Autowired
    private SubscriptionService subscriptionService;

    @GetMapping("/{userId}/default")
    public ResponseEntity<?> subscriptionUser(@PathVariable String userId){
        try {
            SubscriptionPayload subscriptionData = subscriptionService.createSubscription(userId);
            logger.info("User Subscription Data { }" ,subscriptionData);
            return new ResponseEntity<>(subscriptionData, HttpStatus.OK);

        }catch(Exception e){
            logger.error("Opps Error!!!!" ,e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }


    }

    @GetMapping("/{userId}")
    public ResponseEntity<?> getSubscriptionUser(@PathVariable String userId){

        try{
            SubscriptionPayload payloadData = subscriptionService.getSubScriptions(userId);
            logger.info("Payload Data is .....", payloadData);
            return new ResponseEntity<>(payloadData, HttpStatus.OK);
        }catch(Exception e){
            logger.error("Error Occoured.....", e.getMessage());
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);

        }

    }
}
