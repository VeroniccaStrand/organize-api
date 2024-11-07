package com.strandDev.organize_me.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


import java.util.Set;
import java.util.UUID;


@Getter
@Setter
@Entity
@Table(name = "users", uniqueConstraints = { @UniqueConstraint(columnNames = "email") })
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    private String username;
    @Column(unique = true)
    @Email(message = "Email must be valid")
    private String email;

    @NotNull
    private String password;

    @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL)
    private Set<Project> projects;

    @ManyToMany(mappedBy = "assignedUsers")
    private Set<Project> assignedProjects;


    public User() {}

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public User(String username, String email, String password, Set<Project> projects, Set<Project> assignedProjects) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.projects = projects;
        this.assignedProjects = assignedProjects;
    }
}
