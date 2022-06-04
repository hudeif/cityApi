package com.example.cityApi.Controller;

import com.example.cityApi.Interfaces.IUser;
import com.example.cityApi.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("users")
@CrossOrigin(maxAge = 3600)
public class UserController {
    @Autowired
    IUser iUser;

    @PostMapping("/login")
    public User login(@RequestBody User user){
         User u = iUser.checkUser(user.getEmail(),user.getPassword());
         if(u != null){
             return u;
         }else{
            return null ;
         }
    }
}
