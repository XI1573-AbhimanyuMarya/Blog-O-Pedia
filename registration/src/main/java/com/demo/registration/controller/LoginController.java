package com.demo.registration.controller;

import com.demo.registration.dto.LoginRequestDto;
import com.demo.registration.dto.LoginResponseDto;
import com.demo.registration.jwt.util.JwtUtil;
import com.demo.registration.service.LoginUserDetailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/api/auth")
public class LoginController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private LoginUserDetailService loginUserDetailService;
    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/signin")
    public ResponseEntity<?> signIn(@RequestBody LoginRequestDto loginRequestDto) {

        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequestDto.getEmail(), loginRequestDto.getPassword()));
        } catch (BadCredentialsException exc) {
            throw new UsernameNotFoundException("Bad Credentials");
        }

        final UserDetails userDetails = loginUserDetailService.loadUserByUsername(loginRequestDto.getEmail());
        String token = jwtUtil.generateToken(userDetails);
        log.info("Token generated Successfully: "+token);
        return ResponseEntity.ok(new LoginResponseDto(token,loginRequestDto.getEmail()));
    }

}
