package com.project.oop.PMS.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "memberproject")
public class MemberProject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer memberID;

    @Column(name = "projectID")
    private Integer projectID;

    @Column(name = "userID")
    private Integer userID;

    // Getters and Setters
}
