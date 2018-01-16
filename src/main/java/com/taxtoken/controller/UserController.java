package com.taxtoken.controller;

import com.taxtoken.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.taxtoken.service.UserService;

@Controller
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String index() {
        return "index";
    }


    @RequestMapping(method = RequestMethod.GET, path = "/user")
    public String user(Model model) {
        model.addAttribute("users", userService.getAllUser());
        return "user";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/user/{name}")
    public String user(@PathVariable String name, Model model) {
        model.addAttribute("users", userService.getUser(name));
        return "user";
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
