package com.strandDev.organize_me.dto;

import com.strandDev.organize_me.model.enums.ProjectStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.UUID;

@Getter
@Setter
public class ProjectDto {
    @NotNull(message = "You need to name your Project")
    private String title;
    private String description;

    @NotNull(message = "Owner is required")
    private UUID ownerId;

    private Set<UUID> assignedUsers;
    private ProjectStatus status;


}
