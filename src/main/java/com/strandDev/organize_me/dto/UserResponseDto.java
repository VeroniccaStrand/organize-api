package com.strandDev.organize_me.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class UserResponseDto {
    private UUID id;
    private String username;
    private String email;

    public UserResponseDto(UUID id,String username,String email) {
        this.id = id;
        this.username = username;
        this.email = email;
    }
}
