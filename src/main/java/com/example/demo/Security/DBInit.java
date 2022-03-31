package com.example.demo.Security;

import com.example.demo.Entity.UserData;
import com.example.demo.Repository.UserRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DBInit {


    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    public DBInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;


    }

}