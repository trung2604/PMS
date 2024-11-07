package com.project.oop.PMS.repository;

import com.project.oop.PMS.entity.ManagerProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ManagerProjectRepository extends JpaRepository<ManagerProject, Integer> {
    // You can add custom queries here if needed
}
