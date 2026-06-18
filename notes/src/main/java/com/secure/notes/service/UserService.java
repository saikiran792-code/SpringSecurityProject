package com.secure.notes.service;

import com.secure.notes.model.Users;
import com.secure.notes.repo.UserRepo;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepo repo;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private BCryptPasswordEncoder encoder =new BCryptPasswordEncoder(12);
    public Users register(Users user)
    {
        user.setPassword(encoder.encode(user.getPassword()));
       return repo.save(user);
    }



    public Users Updatepassword(int id, String password) {
        Users user = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
        user.setPassword(passwordEncoder.encode(password));
        return repo.save(user);

    }
}
