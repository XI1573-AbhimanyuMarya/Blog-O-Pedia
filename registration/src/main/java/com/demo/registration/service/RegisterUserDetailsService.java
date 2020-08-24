package com.demo.registration.service;

import com.demo.registration.dto.RegisterRequestDto;
import com.demo.registration.model.UserEntity;
import com.demo.registration.repository.UserEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserDetailsService {
    @Autowired
    private UserEntityRepo userEntityRepo;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserEntity createUser(RegisterRequestDto registerRequestDto)
    {
        UserEntity user=new UserEntity();
        user.setEmail(registerRequestDto.getEmail());
        user.setUsername(registerRequestDto.getUsername());
        user.setPassword(passwordEncoder.encode(registerRequestDto.getPassword()));

       return userEntityRepo.save(user);

    }



}
