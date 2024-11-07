package com.strandDev.organize_me.model;

import com.strandDev.organize_me.model.enums.ProjectStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;



import java.util.Set;
import java.util.UUID;


@Getter
@Setter
@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    private String title;
    private String description;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    @ManyToMany
    @JoinTable(
            name = "project_users",
            joinColumns = @JoinColumn(name = "project_id", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private Set<User> assignedUsers;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Task> tasks;



    @Enumerated(EnumType.STRING)
    private ProjectStatus status = ProjectStatus.IN_PROGRESS;

    public Project() {

    }
    public Project(String title, String description, User owner, Set<User> assignedUsers, Set<Task> tasks, ProjectStatus status) {
        this.title = title;
        this.description = description;
        this.owner = owner;
        this.assignedUsers = assignedUsers;
        this.tasks = tasks;
        this.status = status;
    }
    public Project(String title, User owner) {
        this.title = title;
        this.owner = owner;

    }
}
