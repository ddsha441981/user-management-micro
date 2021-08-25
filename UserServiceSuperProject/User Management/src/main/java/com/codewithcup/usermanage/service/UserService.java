package com.codewithcup.usermanage.service;

import com.codewithcup.usermanage.entity.User;
import com.codewithcup.usermanage.payload.UserPayload;

import java.util.List;

public interface UserService {
    public UserPayload saveUser(UserPayload userPayload);

    public List<UserPayload> getUser();

    public UserPayload findOne(String userId);

    public UserPayload updateUser(UserPayload userPayload);

    public void deleteUser(String userId);

}
