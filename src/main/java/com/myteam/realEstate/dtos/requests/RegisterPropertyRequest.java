package com.myteam.realEstate.dtos.requests;

import com.myteam.realEstate.data.models.UserRole;
import jakarta.persistence.Entity;
import lombok.Data;

@Entity
@Data
public class RegisterPropertyRequest {

    private String propertyName;
    private String description;
    private double price;
    private UserRole role;
    private boolean available;

}
