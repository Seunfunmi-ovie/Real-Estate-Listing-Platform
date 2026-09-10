package com.myteam.realEstate.dtos.responses;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.util.UUID;

@Data
public class RegisterPropertyResponse {
    private int id;
    private String message;


}
