package com.myteam.realEstate.controllers;


import com.myteam.realEstate.dtos.requests.RegisterPropertyRequest;
import com.myteam.realEstate.dtos.requests.UpdatePropertyRequest;
import com.myteam.realEstate.dtos.responses.RegisterPropertyResponse;
import com.myteam.realEstate.dtos.responses.RemovePropertyResponse;
import com.myteam.realEstate.dtos.responses.UpdatePropertyResponse;
import com.myteam.realEstate.services.RegisterPropertyService;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/properties")
public class PropertyController {

    private final RegisterPropertyService registerPropertyService;

    PropertyController(RegisterPropertyService registerPropertyService) {
        this.registerPropertyService = registerPropertyService;
    }


    @PostMapping("/register")
    RegisterPropertyResponse register(@RequestBody RegisterPropertyRequest request) {
        return registerPropertyService.registerProperty(request);
    }

    @PutMapping("/{id}")
    UpdatePropertyResponse updateProperty(@PathVariable int id, @RequestBody UpdatePropertyRequest request) {
        return registerPropertyService.updateProperty(id,  request);
    }

    @DeleteMapping("/{id}")
    RemovePropertyResponse  removeProperty(@PathVariable int id) {
        return registerPropertyService.removeProperty(id);
    }

}