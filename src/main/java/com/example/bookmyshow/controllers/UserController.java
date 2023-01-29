package com.example.bookmyshow.controllers;

import com.example.bookmyshow.dtos.CreateUserRequestDto;
import com.example.bookmyshow.dtos.CreateUserResponseDto;
import com.example.bookmyshow.models.User;
import com.example.bookmyshow.services.UserService;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    private UserService userService;

    public UserController(UserService userService)
    {
        this.userService = userService;
    }

    public CreateUserResponseDto createUser(CreateUserRequestDto request)
    {
        User savedUser = userService.createUser(request.getEmail());

        CreateUserResponseDto response = new CreateUserResponseDto();
        response.setUser(savedUser);
        return response;
    }
}
