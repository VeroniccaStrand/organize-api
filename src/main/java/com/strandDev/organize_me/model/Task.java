package com.strandDev.organize_me.model;

import com.strandDev.organize_me.model.enums.Priority;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name = "tasks")

public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    private String title;
    private boolean completed = false;
    private Priority priority = Priority.LOW;

    @ManyToOne
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    public Task() {}

    public Task(String title, Project project) {
        this.title = title;
        this.project = project;
    }
    public Task(String title, boolean completed, Priority priority, Project project) {
        this.title = title;
        this.completed = completed;
        this.priority = priority;
        this.project = project;
    }
}
