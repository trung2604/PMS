package com.project.oop.PMS.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "users") // ánh xạ với bảng "users" trong cơ sở dữ liệu
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userID;

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email")
    private String email;
}
