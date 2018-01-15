package com.taxtoken.controller;

import com.taxtoken.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.taxtoken.service.UserService;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/user")
    @ResponseBody
    public List<User> getUser() {
        return userService.getAllUser();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{name}/birthday")
    public String getBirthday(@PathVariable String name) {
        return userService.getUser(name).getBirthday();
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{name}/age")
    public Integer getAge(@PathVariable String name) {
        return userService.getUser(name).getAge();
    }

    @RequestMapping(method = RequestMethod.POST, path = "/user")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/user/{name}")
    public ResponseEntity<String> updateUser(@PathVariable String name, @RequestBody User user) {
        user.setName(name);
        userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }
}
