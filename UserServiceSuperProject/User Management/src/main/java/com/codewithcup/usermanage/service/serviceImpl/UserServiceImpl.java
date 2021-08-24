package com.codewithcup.usermanage.service.serviceImpl;

import com.codewithcup.usermanage.entity.User;
import com.codewithcup.usermanage.payload.UserPayload;
import com.codewithcup.usermanage.repository.UserRepository;
import com.codewithcup.usermanage.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    UserRepository userRepository;

    @Override
    public UserPayload saveUser(UserPayload userPayload) {

        User user = userPayload.mapToModel();
        user.setCreatedDate(new Date());
        userRepository.save(user);
        return new UserPayload(user);
    }

    @Override
    public List<User> getUser() {
        return null;
    }

    @Override
    public User getUserById(String userId) {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public void deleteUser(String userId) {

    }
}
