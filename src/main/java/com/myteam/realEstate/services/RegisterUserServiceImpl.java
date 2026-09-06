package com.myteam.realEstate.services;

import com.myteam.realEstate.data.models.User;
import com.myteam.realEstate.data.repositories.UserRepository;
import com.myteam.realEstate.dtos.requests.LoginUserRequest;
import com.myteam.realEstate.dtos.requests.LogoutUserRequest;
import com.myteam.realEstate.dtos.requests.RegisterUserRequest;
import com.myteam.realEstate.dtos.responses.LoginUserResponse;
import com.myteam.realEstate.dtos.responses.LogoutUserResponse;
import com.myteam.realEstate.dtos.responses.RegisterUserResponse;
import org.springframework.stereotype.Service;


@Service
public class RegisterUserServiceImpl implements RegisterUserService{

    private final UserRepository userRepository;

    public RegisterUserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public RegisterUserResponse registerUser(RegisterUserRequest request) {
        User user = new User();
        user.setUserName(request.getUserName());
        user.setName(request.getName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole(request.getRole());
        User savedUser = userRepository.save(user);

        RegisterUserResponse response =  new RegisterUserResponse();
        response.setMessage("Registration Successful....");
        response.setRole(savedUser.getRole());

        return response;
    }

    @Override
    public LoginUserResponse loginUser(LoginUserRequest request) {
       User existingUser = userRepository.findByEmail(request.getEmail());
       if(existingUser == null || !existingUser.getPassword().equals(request.getPassword())){
           throw new IllegalArgumentException("Incorrect Password or Username");

       }

       userRepository.save(existingUser);
       LoginUserResponse response = new LoginUserResponse();
       response.setMessage("Login Successful...");


       return response;
    }


    @Override
    public LogoutUserResponse logoutUser(LogoutUserRequest request) {
        User existingUser = userRepository.findByUserName(request.getUserName());
        if(existingUser == null || !existingUser.getUserName().equals(request.getUserName())){
            throw new IllegalArgumentException("User Not Found");
        }

        userRepository.save(existingUser);
        LogoutUserResponse response = new LogoutUserResponse();
        response.setMessage("LogOut Successful....");

        return response;
    }
}
