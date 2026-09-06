package com.myteam.realEstate.controllers;

import com.myteam.realEstate.dtos.requests.LoginUserRequest;
import com.myteam.realEstate.dtos.requests.LogoutUserRequest;
import com.myteam.realEstate.dtos.requests.RegisterUserRequest;
import com.myteam.realEstate.dtos.responses.LoginUserResponse;
import com.myteam.realEstate.dtos.responses.LogoutUserResponse;
import com.myteam.realEstate.dtos.responses.RegisterUserResponse;
import com.myteam.realEstate.services.RegisterUserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")

public class UserController {

    private final RegisterUserService registerUserService;


    public UserController(RegisterUserService registerUserService) {
        this.registerUserService = registerUserService;
    }

    @PostMapping("/register")
    public RegisterUserResponse register(@RequestBody RegisterUserRequest request) {
        return registerUserService.registerUser(request);
    }

    @PostMapping("/login")
    public LoginUserResponse login(@RequestBody LoginUserRequest request) {
        return registerUserService.loginUser(request);
    }

    @PostMapping("/logout")
    public LogoutUserResponse logout(@RequestBody LogoutUserRequest request){
        return registerUserService.logoutUser(request);
    }

}
