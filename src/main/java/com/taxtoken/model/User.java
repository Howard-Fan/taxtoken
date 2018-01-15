package com.taxtoken.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class User {

    public User() {

    }

    public User(String name, String birthday, Integer age) {
        this.name = name;
        this.birthday = birthday;
        this.age = age;
    }

    @Id
    private String name;
    private String birthday;
    private Integer age;


    @Override
    public String toString() {
        return String.format("User[name='%s', birthday='%s', age=%d]", name, birthday, age);
    }
}
