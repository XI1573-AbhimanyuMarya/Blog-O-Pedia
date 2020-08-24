package com.demo.registration.service;

import com.demo.registration.dto.PostsRequestDto;
import com.demo.registration.model.PostsEntity;
import com.demo.registration.repository.PostEntityRepo;
import javassist.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Slf4j
@Service
public class PostsService {
    @Autowired
    private PostEntityRepo postEntityRepo;
    @Autowired
    private LoginUserDetailService loginUserDetailService;


    public PostsEntity createPosts(PostsRequestDto postsRequestDto) {
        // todo Part-6 ,11 min
        User currentUser = loginUserDetailService.getCurrentUser()
                .orElseThrow(()-> new IllegalArgumentException("No Logged inUser found"));

/*        log.info("--------: "+currentUser.getUsername());*/

        PostsEntity posts = new PostsEntity();
        posts.setTitle(postsRequestDto.getTitle());
        posts.setContent(postsRequestDto.getContent());
        posts.setUsername(currentUser.getUsername());
        posts.setCreatedOn(Instant.now());

        return postEntityRepo.save(posts);

    }

    public List<PostsEntity> findAllPosts() {
        return postEntityRepo.findAll();
    }

    public PostsEntity getSinglePosts(Long id) throws NotFoundException {

/*
        return postEntityRepo.findByTitle(title).orElseThrow(()-> new NotFoundException("Title Not Found"));
*/
        return postEntityRepo.findById(id).orElseThrow(()-> new NotFoundException("Id Not Found"));

    }
}
