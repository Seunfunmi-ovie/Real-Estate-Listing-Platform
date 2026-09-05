package com.myteam.realEstate.data.repositories;

import com.myteam.realEstate.data.models.Property;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PropertyRepository extends JpaRepository<Property, Integer> {
    Property findByPrice(double price);
}
