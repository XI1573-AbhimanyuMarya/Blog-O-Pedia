package com.demo.registration.controller;

import com.demo.registration.dto.RegisterRequestDto;
import com.demo.registration.model.UserEntity;
import com.demo.registration.repository.UserEntityRepo;
import com.demo.registration.service.RegisterUserDetailsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
class RegisterControllerTest {


    @Autowired
    MockMvc mockMvc;

    @Test
    void signUp() throws Exception {

        ObjectMapper mapper = new ObjectMapper();

        RegisterRequestDto registerRequestDto = new RegisterRequestDto("abc", "abc", "abcffffdd@gmail.com");

        mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/signup")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(registerRequestDto))
                 )
                .andExpect(MockMvcResultMatchers.status().isOk());

    }
}