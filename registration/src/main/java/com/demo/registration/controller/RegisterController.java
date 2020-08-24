package com.demo.registration.controller;

import com.demo.registration.dto.RegisterRequestDto;
import com.demo.registration.dto.RegisterResponseDto;
import com.demo.registration.service.RegisterUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class RegisterController {

    @Autowired private RegisterUserDetailsService detailsService;
    @PostMapping("/signup")
    public ResponseEntity<?> signUp(@RequestBody RegisterRequestDto registerRequestDto)
    {
        detailsService.createUser(registerRequestDto);
        return ResponseEntity.ok(new RegisterResponseDto(registerRequestDto.getUsername(),registerRequestDto.getEmail()));
    }

}
