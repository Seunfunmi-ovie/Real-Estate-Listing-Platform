package com.myteam.realEstate.dtos.requests;

import com.myteam.realEstate.data.models.UserRole;
import lombok.Data;



@Data
public class RegisterUserRequest {
    private String name;
    private String userName;
    private String email;
    private String password;
    private UserRole role;
}
