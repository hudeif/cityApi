package com.example.cityApi.Interfaces;

import com.example.cityApi.Models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUser extends JpaRepository<User,Integer> {

    @Query(value = "Select * from user where user.email=?1 and user.password=?2",nativeQuery = true)
    User checkUser(String email,String password);
}
