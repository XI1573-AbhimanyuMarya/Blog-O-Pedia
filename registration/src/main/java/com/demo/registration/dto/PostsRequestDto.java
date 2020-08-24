package com.demo.registration.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PostsRequestDto {
    private String content;
    private String title;

}
