package com.myteam.realEstate.services;

import com.myteam.realEstate.data.models.Property;
import com.myteam.realEstate.data.models.User;
import com.myteam.realEstate.data.repositories.PropertyRepository;
import com.myteam.realEstate.data.repositories.UserRepository;
import com.myteam.realEstate.dtos.requests.RegisterPropertyRequest;

import com.myteam.realEstate.dtos.requests.UpdatePropertyRequest;
import com.myteam.realEstate.dtos.responses.RegisterPropertyResponse;
import com.myteam.realEstate.dtos.responses.RemovePropertyResponse;
import com.myteam.realEstate.dtos.responses.UpdatePropertyResponse;

public class RegisterPropertyServiceImpl implements RegisterPropertyService {

        private final PropertyRepository propertyRepository;
        private final UserRepository userRepository;

        public RegisterPropertyServiceImpl(PropertyRepository propertyRepository, UserRepository userRepository){
            this.propertyRepository = propertyRepository;
            this.userRepository = userRepository;
        }

    @Override
    public RegisterPropertyResponse registerProperty(RegisterPropertyRequest request) {

        User agent = userRepository.findById(request.getAgentId())
                .orElseThrow(() -> new RuntimeException("Agent not found"));
        User owner = userRepository.findById(request.getOwnerId())
                .orElseThrow(() -> new RuntimeException("Owner not found"));
        if (agent.getId() == owner.getId()) {
            throw new RuntimeException("Agent and owner cannot be the same user");
        }

        Property property = new Property();
        property.setTitle(request.getTitle());
        property.setPrice(request.getPrice());
        property.setDescription(request.getDescription());
        property.setOwner(owner);
        property.setAgent(agent);
        property.setAvailable(false);

        Property savedProperty = propertyRepository.save(property);

        RegisterPropertyResponse registerPropertyResponse = new RegisterPropertyResponse();
        registerPropertyResponse.setId(savedProperty.getId());
        registerPropertyResponse.setMessage("Registration Successful....");
        return registerPropertyResponse;
    }

    @Override
    public UpdatePropertyResponse updateProperty(int id,UpdatePropertyRequest request) {
        Property existingProperty = propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found"));
        existingProperty.setTitle(request.getTitle());
        existingProperty.setPrice(request.getPrice());
        existingProperty.setDescription(request.getDescription());

        Property savedProperty = propertyRepository.save(existingProperty);

        UpdatePropertyResponse updatePropertyResponse = new UpdatePropertyResponse();
        updatePropertyResponse.setMessage("Update Successful....");

        return updatePropertyResponse;

    }

    @Override
    public RemovePropertyResponse removeProperty(int id) {
        Property property = propertyRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Property not found"));

        property.setAvailable(false);
        propertyRepository.save(property);

        RemovePropertyResponse removePropertyResponse = new RemovePropertyResponse();
        removePropertyResponse.setMessage("Remove Successful....");
        return removePropertyResponse;
    }
}
