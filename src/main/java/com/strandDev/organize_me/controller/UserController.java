package com.strandDev.organize_me.controller;


import com.strandDev.organize_me.dto.UserRequestDto;
import com.strandDev.organize_me.dto.UserResponseDto;
import com.strandDev.organize_me.model.User;
import com.strandDev.organize_me.service.UserService;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody UserRequestDto userRequestDto){
        User user = userService.createUser(userRequestDto);

        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
    @GetMapping("/all")
    public ResponseEntity<List<UserResponseDto>> GetAllUsers(){
        List<UserResponseDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
