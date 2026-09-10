package com.myteam.realEstate.data.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "properties")
@Getter
@Setter
public class Property {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    @ManyToOne
    private User agent;
    @ManyToOne(optional = false)
    private User owner;
    private String title;
    private double price;
    private String description;
    private boolean available;

}

