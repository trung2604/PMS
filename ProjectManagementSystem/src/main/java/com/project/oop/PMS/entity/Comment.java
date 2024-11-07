package com.project.oop.PMS.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentID;

    @Column(name = "taskID")
    private Integer taskID;

    @Column(name = "createDate")
    private Date createDate;

    @Column(name = "author")
    private String author;

    @Column(name = "description")
    private String description;

    // Getters and Setters
}
