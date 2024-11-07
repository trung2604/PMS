package com.project.oop.PMS.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users") // Ánh xạ với bảng "users"
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userID;

    @Column(name = "username", nullable = false, unique = true)
    private String name;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email")
    private String email;

    // Các getter và setter
    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
