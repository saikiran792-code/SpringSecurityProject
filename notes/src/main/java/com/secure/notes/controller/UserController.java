package com.secure.notes.controller;

import com.secure.notes.model.Users;
import com.secure.notes.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
   @Autowired
   private UserService service;


    @PostMapping("/register")
    public Users Register( @RequestBody Users user){
        return service.register(user);
    }
    @PutMapping("/UpdatePassword/{id}")
    public Users Updatepassword(@PathVariable int id,
            @RequestBody Users user){
        return service.Updatepassword(id,user.getPassword());
    }
    @PostMapping("/login")
    public String login(@RequestBody Users user){
        System.out.println(user);
        return service.verify(user);
    }
}
