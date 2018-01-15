package com.taxtoken.model;

import lombok.Data;

@Data
public class User {

    public User(String name, String birthday, Integer age) {
        this.name = name;
        this.birthday = birthday;
        this.age = age;
    }

    private String name;
    private String birthday;
    private Integer age;
}
