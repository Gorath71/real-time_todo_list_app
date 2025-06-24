package com.project.tutorial.repository;

import com.project.tutorial.model.UserTaskListAccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserTaskListAccessRepository extends JpaRepository<UserTaskListAccess, Long> {
}
