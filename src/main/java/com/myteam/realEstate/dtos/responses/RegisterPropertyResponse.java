package com.myteam.realEstate.dtos.responses;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

import java.util.UUID;

@Data
public class RegisterPropertyResponse {
        @id
        @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String message;


}
