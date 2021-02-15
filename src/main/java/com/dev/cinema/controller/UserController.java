package com.dev.cinema.controller;

import com.dev.cinema.model.User;
import com.dev.cinema.model.dto.UserRequestDto;
import com.dev.cinema.model.dto.UserResponseDto;
import com.dev.cinema.service.UserService;
import com.dev.cinema.service.impl.mapper.UserMapper;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final UserMapper userMapper;

    @Autowired
    public UserController(UserService userService,
                          UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
    }

    @GetMapping
    public UserResponseDto findByEmail(@RequestParam String email) {
        Optional<User> userByEmail = userService.findByEmail(email);
        return userMapper.toDto(userByEmail.orElseThrow(()
                -> new RuntimeException("User by email " + email
                + " wasn't found")));
    }

    @PostMapping
    public void add(@RequestBody UserRequestDto userRequestDto) {
        userService.add(userMapper.toEntity(userRequestDto));
    }
}
