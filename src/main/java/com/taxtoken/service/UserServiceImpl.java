package com.taxtoken.service;

import com.taxtoken.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {
    public void createUser(User user) {

    }

    public User getUser(String name) {
        return new User(name, "birthday", 25);
    }

    public void updateUser(String name, String birthday, Integer age) {

    }
}
