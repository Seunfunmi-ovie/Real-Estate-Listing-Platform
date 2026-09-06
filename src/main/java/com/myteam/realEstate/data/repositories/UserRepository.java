package com.myteam.realEstate.data.repositories;


import com.myteam.realEstate.data.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
    User findByEmail(String email);
    User findByUserName(String userName);
}
