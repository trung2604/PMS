package com.project.oop.PMS.repository;

import com.project.oop.PMS.entity.MemberProject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberProjectRepository extends JpaRepository<MemberProject, Integer> {
    // You can add custom queries here if needed
}