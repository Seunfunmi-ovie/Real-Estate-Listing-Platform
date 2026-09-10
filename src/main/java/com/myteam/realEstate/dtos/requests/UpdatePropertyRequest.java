package com.myteam.realEstate.dtos.requests;

import lombok.Data;

@Data
public class UpdatePropertyRequest {
    private String title;

    private double price;
    private String description;


}
