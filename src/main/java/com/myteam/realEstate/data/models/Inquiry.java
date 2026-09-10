package com.myteam.realEstate.data.models;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "inquiries")
@Getter
@Setter
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
