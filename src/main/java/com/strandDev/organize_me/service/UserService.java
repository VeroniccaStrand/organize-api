package com.strandDev.organize_me.service;

import com.strandDev.organize_me.dto.UserRequestDto;
import com.strandDev.organize_me.dto.UserResponseDto;
import com.strandDev.organize_me.model.User;
import com.strandDev.organize_me.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserRequestDto userRequestDto) {
        if(userRepository.existsByEmail(userRequestDto.getEmail())) {
            throw new IllegalArgumentException("User with email " + userRequestDto.getEmail() + " already exists");
        }
        User user = new User();
        user.setUsername(userRequestDto.getUsername());
        user.setEmail(userRequestDto.getEmail());
        user.setPassword(userRequestDto.getPassword());
        return userRepository.save(user);
    }

    public List<UserResponseDto> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponseDto(user.getId(),user.getUsername(), user.getEmail()))
                .collect(Collectors.toList());
    }
}
