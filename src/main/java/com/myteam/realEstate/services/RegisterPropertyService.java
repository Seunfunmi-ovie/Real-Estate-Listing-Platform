package com.myteam.realEstate.services;

import com.myteam.realEstate.dtos.requests.RegisterPropertyRequest;
import com.myteam.realEstate.dtos.requests.RemovePropertyRequest;
import com.myteam.realEstate.dtos.requests.UpdatePropertyRequest;
import com.myteam.realEstate.dtos.responses.RegisterPropertyResponse;
import com.myteam.realEstate.dtos.responses.RemovePropertyResponse;
import com.myteam.realEstate.dtos.responses.UpdatePropertyResponse;

public interface RegisterPropertyService {

    RegisterPropertyResponse registerProperty(RegisterPropertyRequest request);
    UpdatePropertyResponse updateProperty(int id,UpdatePropertyRequest request);
    RemovePropertyResponse removeProperty(int id);
}
