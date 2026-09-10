package com.myteam.realEstate.data.repositories;

import com.myteam.realEstate.data.models.Inquiry;
import com.myteam.realEstate.data.models.Property;
import com.myteam.realEstate.data.models.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InquiryRepository extends JpaRepository<Inquiry, Integer> {
    List<Inquiry> findByStatus(Status status);
    List<Inquiry>findByProperty(Property property);
}

