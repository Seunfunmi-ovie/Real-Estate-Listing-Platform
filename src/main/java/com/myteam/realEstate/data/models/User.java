package com.myteam.realEstate.data.models;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
public class
User {
    private String name;
    private String userName;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String password;

    @OneToMany(mappedBy = "agent")
    private List<Property> propertiesAsAgent;

    @OneToMany(mappedBy = "owner")
    private List<Property> propertiesOwned;
}
