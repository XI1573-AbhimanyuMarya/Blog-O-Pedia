package com.demo.registration.controller;

import com.demo.registration.dto.PostResponseDto;
import com.demo.registration.dto.PostsRequestDto;
import com.demo.registration.model.PostsEntity;
import com.demo.registration.repository.PostEntityRepo;
import com.demo.registration.service.LoginUserDetailService;
import com.demo.registration.service.PostsService;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class PostController {
    @Autowired
    private PostsService postsService;
    @Autowired
    private LoginUserDetailService loginUserDetailService;
    @Autowired
    private PostEntityRepo postEntityRepo;

//todo 13:50 part-6
    @PostMapping("/posts")
    public ResponseEntity<?> createPost(@RequestBody PostsRequestDto postsRequestDto) {

        final PostsEntity posts = postsService.createPosts(postsRequestDto);

        return ResponseEntity.ok(new PostResponseDto(postsRequestDto.getTitle(),postsRequestDto.getContent()));

    }

    @GetMapping("/get-all")
    public List<PostsEntity> getAllPosts()
    {
        List<PostsEntity> allPosts = postsService.findAllPosts();
        return allPosts;
    }

      @GetMapping("/get/{id}")
    public PostsEntity getSinglePosts(@PathVariable @RequestBody Long id) throws NotFoundException {
          PostsEntity singlePosts = postsService.getSinglePosts(id);
          log.info("Get Bt Title: "+ singlePosts);
            return singlePosts;

      }




}
