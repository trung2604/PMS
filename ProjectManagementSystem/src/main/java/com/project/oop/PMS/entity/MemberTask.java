package com.project.oop.PMS.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "membertask")
public class MemberTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberID;

    @Column(name = "taskID")
    private Integer taskID;

    @Column(name = "userID")
    private Integer userID;

    // Getters and Setters
}
