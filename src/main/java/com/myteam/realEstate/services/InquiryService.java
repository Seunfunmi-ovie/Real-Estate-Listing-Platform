package com.myteam.realEstate.services;

import com.myteam.realEstate.data.models.Inquiry;
import com.myteam.realEstate.dtos.requests.CreateInquiryRequest;
import com.myteam.realEstate.dtos.responses.CloseInquiryResponse;
import com.myteam.realEstate.dtos.responses.CreateInquiryResponse;

import java.util.List;

public interface InquiryService {

    CreateInquiryResponse createInquiry(CreateInquiryRequest request);
    CloseInquiryResponse closeInquiry(int inquiryId);
    List<Inquiry> getInquiriesForProperties(int propertyId);
}
