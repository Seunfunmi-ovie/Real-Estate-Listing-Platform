package com.myteam.realEstate.data.repositories;

import com.myteam.realEstate.data.models.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Integer> {
    List<Property> findByPrice(double price);
}
