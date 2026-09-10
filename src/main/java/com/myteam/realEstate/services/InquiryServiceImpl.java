package com.myteam.realEstate.services;

import com.myteam.realEstate.data.models.Inquiry;
import com.myteam.realEstate.data.models.Property;
import com.myteam.realEstate.data.models.Status;
import com.myteam.realEstate.data.models.User;
import com.myteam.realEstate.data.repositories.InquiryRepository;
import com.myteam.realEstate.data.repositories.PropertyRepository;
import com.myteam.realEstate.data.repositories.UserRepository;
import com.myteam.realEstate.dtos.requests.CreateInquiryRequest;
import com.myteam.realEstate.dtos.responses.CloseInquiryResponse;
import com.myteam.realEstate.dtos.responses.CreateInquiryResponse;

import java.util.List;

public class InquiryServiceImpl implements InquiryService {

    private InquiryRepository inquiryRepository;
    private UserRepository userRepository;
    private PropertyRepository propertyRepository;

    public InquiryServiceImpl(InquiryRepository inquiryRepository, UserRepository userRepository, PropertyRepository propertyRepository) {
        this.inquiryRepository = inquiryRepository;
        this.userRepository = userRepository;
        this.propertyRepository = propertyRepository;
    }

    @Override
    public CreateInquiryResponse createInquiry(CreateInquiryRequest request) {
        Property property = propertyRepository.findById(request.getPropertyId())
                .orElseThrow(() -> new RuntimeException("Property not found"));

        User buyer = userRepository.findById(request.getBuyerId())
                .orElseThrow(() -> new RuntimeException("Buyer not found"));

        Inquiry inquiry = new Inquiry();
        inquiry.setBuyer(buyer);
        inquiry.setProperty(property);
        inquiry.setMessage(request.getMessage());
        inquiry.setStatus(Status.PENDING);

        Inquiry savedInquiry = inquiryRepository.save(inquiry);

        CreateInquiryResponse response = new CreateInquiryResponse();
        response.setInquiryId(savedInquiry.getId());
        response.setMessage("Inquiry created");
        return response;

    }

    @Override
    public CloseInquiryResponse closeInquiry(int inquiryId) {
        Inquiry existingInquiry = inquiryRepository.findById(inquiryId)
           .orElseThrow(() -> new RuntimeException("Inquiry not found"));

        existingInquiry.setStatus(Status.CLOSED);

        Inquiry savedInquiry = inquiryRepository.save(existingInquiry);

        CloseInquiryResponse response = new CloseInquiryResponse();
        response.setMessage("Inquiry closed");
        return response;

    }

    @Override
    public List<Inquiry> getInquiriesForProperties(int propertyId) {
        Property existingProperty = propertyRepository.findById(propertyId)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        return inquiryRepository.findByProperty(existingProperty);
    }
}