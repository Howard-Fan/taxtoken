package com.taxtoken.service;

import com.taxtoken.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User createUser(User user);
    User getUser(String name);
    User updateUser(User user);
}
