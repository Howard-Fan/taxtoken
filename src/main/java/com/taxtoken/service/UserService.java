package com.taxtoken.service;

import com.taxtoken.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User createUser(User user);
    User getUser(String name);
    User updateUser(User user);
    List<User> getAllUser();
}
