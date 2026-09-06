package com.myteam.realEstate.dtos.requests;

import lombok.Data;

@Data
public class LoginUserRequest {
    private String userName;
    private String password;
    private String email;
}
