package com.project.oop.PMS.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "managerproject")
public class ManagerProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer managerID;

    @Column(name = "projectID")
    private Integer projectID;

    @Column(name = "userID")
    private Integer userID;

    // Getters and Setters
}
