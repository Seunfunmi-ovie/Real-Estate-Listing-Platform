package com.myteam.realEstate.services;

import com.myteam.realEstate.dtos.requests.LoginUserRequest;
import com.myteam.realEstate.dtos.requests.LogoutUserRequest;
import com.myteam.realEstate.dtos.requests.RegisterUserRequest;
import com.myteam.realEstate.dtos.responses.LoginUserResponse;
import com.myteam.realEstate.dtos.responses.LogoutUserResponse;
import com.myteam.realEstate.dtos.responses.RegisterUserResponse;

public interface RegisterUserService {
    RegisterUserResponse registerUser(RegisterUserRequest request);
    LoginUserResponse loginUser(LoginUserRequest request);
    LogoutUserResponse logoutUser(LogoutUserRequest request);

}
