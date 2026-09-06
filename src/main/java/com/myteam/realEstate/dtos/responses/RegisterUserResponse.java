package com.myteam.realEstate.dtos.responses;

import com.myteam.realEstate.data.models.UserRole;
import lombok.Data;

@Data
public class RegisterUserResponse {
    private String userName;
    private String message;
    private UserRole role;
}
