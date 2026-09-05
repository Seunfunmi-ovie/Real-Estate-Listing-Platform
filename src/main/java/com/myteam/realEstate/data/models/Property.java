package com.myteam.realEstate.data.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "properties")
@Data
public class Property {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private int agentId;
    private String title;
    private double price;
    private boolean isAvailable;

}

