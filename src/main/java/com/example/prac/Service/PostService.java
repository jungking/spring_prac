package com.example.prac.Service;


import com.example.prac.Domain.Post_Entity;
import com.example.prac.Dto.PostForm;
import com.example.prac.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    public Long save(PostForm postForm){
        return postRepository.save(Post_Entity.builder()
                .title(postForm.getTitle())
                .content(postForm.getContent())
                .userid(postForm.getUserid()).build()).getId();

    }
}
