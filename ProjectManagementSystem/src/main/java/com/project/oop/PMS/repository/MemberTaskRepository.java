package com.project.oop.PMS.repository;

import com.project.oop.PMS.entity.MemberTask;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberTaskRepository extends JpaRepository<MemberTask, Integer> {
    // You can add custom queries here if needed
}
