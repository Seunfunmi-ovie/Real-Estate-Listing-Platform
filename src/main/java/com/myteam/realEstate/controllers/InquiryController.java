package com.myteam.realEstate.controllers;

import com.myteam.realEstate.data.models.Inquiry;
import com.myteam.realEstate.dtos.requests.CreateInquiryRequest;
import com.myteam.realEstate.dtos.responses.CloseInquiryResponse;
import com.myteam.realEstate.dtos.responses.CreateInquiryResponse;
import com.myteam.realEstate.services.InquiryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inquiries")
public class InquiryController {
    private final InquiryService inquiryService;

    public InquiryController(InquiryService inquiryService) {
        this.inquiryService = inquiryService;
    }

    @PostMapping("/createInquiry")
    CreateInquiryResponse createInqury(@RequestBody CreateInquiryRequest createInquiryRequest){
        return inquiryService.createInquiry(createInquiryRequest);

    }

    @PutMapping("/{id}")
    CloseInquiryResponse closeInquiry(@PathVariable int id){
        return inquiryService.closeInquiry(id);
    }

    @GetMapping("/getInquiries/{id}")
    List<Inquiry> getInquiries(@PathVariable int id) {
        return inquiryService.getInquiriesForProperties(id);
    }

}
