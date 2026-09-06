package com.myteam.realEstate.data.models;

import jakarta.persistence.*;
import lombok.Data;
@Entity
@Table(name = "users")
@Data
public class User {
    private String name;
    private String userName;
    private String email;
    @Enumerated(EnumType.STRING)
    private UserRole role;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private int id;
    private String password;

}
