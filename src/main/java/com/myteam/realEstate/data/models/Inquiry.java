package com.myteam.realEstate.data.models;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "inquiries")
@Data
public class Inquiry {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private int propertyId;
    private int buyerId;
    private String message;
    @Enumerated(EnumType.STRING)
    private Status status;



}
