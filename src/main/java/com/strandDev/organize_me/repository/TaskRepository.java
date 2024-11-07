package com.strandDev.organize_me.repository;

import com.strandDev.organize_me.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
