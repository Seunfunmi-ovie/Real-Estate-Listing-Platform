package com.myteam.realEstate.data.repositories;

import com.myteam.realEstate.data.models.Inquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquiryRepository extends JpaRepository<Inquiry, Integer> {
    Inquiry findByPropertyId(int propertyId);
}
