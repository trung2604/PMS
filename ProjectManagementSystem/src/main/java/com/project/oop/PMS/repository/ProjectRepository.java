package com.project.oop.PMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.oop.PMS.entity.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
