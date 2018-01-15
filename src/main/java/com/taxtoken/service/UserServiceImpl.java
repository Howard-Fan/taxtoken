package com.taxtoken.service;

import com.taxtoken.model.User;
import com.taxtoken.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUser(String name) {
        return userRepository.findOne(name);
    }

    public User updateUser(User user) {
        User oldUser = userRepository.findOne(user.getName());
        oldUser.setBirthday(user.getBirthday());
        oldUser.setAge(user.getAge());
        return userRepository.save(oldUser);
    }
}
