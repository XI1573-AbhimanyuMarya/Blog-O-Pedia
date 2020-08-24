package com.demo.registration.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "posts_blogopedia")
public class PostsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    @Column(name = "title", unique = true, length = 200)
    private String title;
    @NotNull @Column(name = "content", length = 2000)
    private String content;
     private Instant createdOn;
    private Instant updatedOn;
    private String username;


}
