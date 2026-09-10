package com.myteam.realEstate.data.models;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "inquiries")
@Getter
@Setter
public class Inquiry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(optional = false)
    private Property property;
    @ManyToOne(optional = false)
    private User buyer;
    private String message;
    @Enumerated(EnumType.STRING)
    private Status status;


}
