package com.strandDev.organize_me.service;

import com.strandDev.organize_me.dto.ProjectDto;
import com.strandDev.organize_me.model.Project;
import com.strandDev.organize_me.repository.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
    public Project createProject(ProjectDto projectDto) {
        Project project = new Project();
        project.setTitle(projectDto.getTitle());
        project.setDescription(projectDto.getDescription());
        owner;
    }
}
