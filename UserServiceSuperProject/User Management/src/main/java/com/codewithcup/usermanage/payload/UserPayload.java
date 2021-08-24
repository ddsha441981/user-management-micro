package com.codewithcup.usermanage.payload;

import com.codewithcup.usermanage.entity.User;

import java.util.Date;

public class UserPayload {

    private String userId;
    private String firstName;
    private String lastName;
    private Integer age;
    private Date createdDate;

    public UserPayload(String userId, String firstName, String lastName, Integer age, Date createdDate) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.createdDate = createdDate;
    }

    public UserPayload(String userId, String firstName, String lastName, Integer age) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public UserPayload() {
    }

    public UserPayload(User user) {
        setUserId(user.getUserId());
        setFirstName(user.getFirstName());
        setLastName(user.getLastName());
        setAge(user.getAge());
        setCreatedDate(user.getCreatedDate());
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public User mapToModel() {
        User user = new User();
        return new User (getFirstName(),getLastName(),getAge());
    }
}
