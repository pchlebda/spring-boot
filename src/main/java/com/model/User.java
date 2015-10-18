package com.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by Piotr on 2015-10-10.
 */


@Entity
public class User {

    @Id
    private String name;
    private String password;

    public User() {
    }

    public User(String userName, String password) {
        this.name = userName;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
