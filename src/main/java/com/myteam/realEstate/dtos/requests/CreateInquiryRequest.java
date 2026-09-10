package com.myteam.realEstate.dtos.requests;


import lombok.Data;

@Data
public class CreateInquiryRequest {

    private int propertyId;
    private int buyerId;
    private String message;
}
