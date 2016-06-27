package com.activiti.abshar.spring.model;

import java.io.Serializable;

public class UserModel implements Serializable {

    private static final long serialVersionUID = -7788619177798333712L;
    protected String id;
    protected String firstName;
    protected String lastName;
    protected String email;
    protected String password;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
