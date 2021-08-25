package com.codewithcup.usermanage.service.serviceImpl;

import com.codewithcup.usermanage.entity.User;
import com.codewithcup.usermanage.payload.SubscriptionPayload;
import com.codewithcup.usermanage.payload.UserPayload;
import com.codewithcup.usermanage.repository.UserRepository;
import com.codewithcup.usermanage.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    UserRepository userRepository;
    @Autowired
    RestTemplate restTemplate;

    @Override
    public UserPayload saveUser(UserPayload userPayload) {

        User user = userPayload.mapToModel();
        user.setCreatedDate(new Date());
        userRepository.save(user);
        return new UserPayload(user);
    }

    @Override
    public List<UserPayload> getUser() {

        List<User> all = this.userRepository
                .findAll().stream()
                .filter(x->x.getAge() > 15)
                .collect(Collectors.toList());
        return new LinkedList(all);

    }

    @Override
    public UserPayload findOne(String userId) {
        User user = userRepository.findById(userId).orElse(null);
        if(user == null){
            throw new IllegalArgumentException();
        }
        SubscriptionPayload subscriptionPayload = getSubscriptionData(userId);

        return new UserPayload(user,subscriptionPayload);
    }

    @Override
    public UserPayload updateUser(UserPayload userPayload) {

        return null;
    }

    @Override
    public void deleteUser(String userId) {

        User user = new  User();
        user.setUserId(userId);
        this.userRepository.deleteById(userId);
    }

    private SubscriptionPayload getSubscriptionData(String userId){
        String url = "https://localhost:8082/subscription/user/"+userId;
        ResponseEntity<SubscriptionPayload> responseEntity;
        try{
            responseEntity = restTemplate.exchange(url, HttpMethod.GET,null,SubscriptionPayload.class);
            System.out.println(responseEntity);
            logger.info("Get Enterprise response status: { }" ,responseEntity.getStatusCode());
            return responseEntity.getBody();

        }catch(HttpStatusCodeException e){
            logger.info("Get Enterprise response status: { } & body : {}" ,e.getStatusCode(),e.getResponseBodyAsString());
        }catch(ResourceAccessException accessException){
            throw new ResourceAccessException("Internal Server Error!!");
        }
        return null;
    }
}
