package com.myteam.realEstate.dtos.requests;


import lombok.Data;


@Data
public class RegisterPropertyRequest {

    private String title;
    private String description;
    private double price;
    private int agentId;
    private int ownerId;


}
