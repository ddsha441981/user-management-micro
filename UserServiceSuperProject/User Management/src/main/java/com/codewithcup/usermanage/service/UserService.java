package com.codewithcup.usermanage.service;

import com.codewithcup.usermanage.entity.User;
import com.codewithcup.usermanage.payload.UserPayload;

import java.util.List;

public interface UserService {
    public UserPayload saveUser(UserPayload userPayload);

    public List<User> getUser();

    public User getUserById(String userId);

    public User updateUser(User user);

    public void deleteUser(String userId);

}
