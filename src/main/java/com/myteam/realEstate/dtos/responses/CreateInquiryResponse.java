package com.myteam.realEstate.dtos.responses;

import com.myteam.realEstate.data.models.Inquiry;
import lombok.Data;

@Data
public class CreateInquiryResponse {
    private int inquiryId;
    private String message;

}
