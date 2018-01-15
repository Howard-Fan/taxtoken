package com.taxtoken.service;

import com.taxtoken.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    void createUser(User user);
    User getUser(String name);
    void updateUser(String name, String birthday, Integer age);
}
