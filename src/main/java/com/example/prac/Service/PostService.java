package com.example.prac.Service;


import com.example.prac.Domain.PostEntity;
import com.example.prac.Dto.PostForm;
import com.example.prac.Repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class PostService {
    @Autowired
    private final PostRepository postRepository;

    @Transactional
    public Long save(PostForm postForm){
        return postRepository.save(PostEntity.builder()
                .title(postForm.getTitle())
                .content(postForm.getContent())
                .userid(postForm.getUserid()).build()).getId();
    }

    @Transactional
    public void postDelete(Long id) throws Exception{
        postRepository.deleteById(id);
    }

    private PostForm convertEntityToDto(PostEntity postEntity){
        return PostForm.builder()
                .id(postEntity.getId())
                .title(postEntity.getTitle())
                .content(postEntity.getContent())
                .userid(postEntity.getUserid())
                .build();
    }

    @Transactional
    public List<PostForm> getPostList(){
        List<PostEntity> postEntities = postRepository.findAll();
        List<PostForm> postDtoList = new ArrayList<>();
        if(postEntities.isEmpty()) return postDtoList;
        for(PostEntity postEntity : postEntities){
            postDtoList.add(this.convertEntityToDto(postEntity));
        }
        return postDtoList;
    }

    @Transactional
    public PostForm getPost(Long id){
        PostEntity postEntity = postRepository.findById(id).get();
        return convertEntityToDto(postEntity);
    }



}
