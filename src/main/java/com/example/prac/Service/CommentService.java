package com.example.prac.Service;

import com.example.prac.Dto.CommentForm;
import com.example.prac.Repository.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CommentService {
    @Autowired
    private final CommentRepository commentRepository;

    @Transactional
    public Long save(CommentForm commentForm){
        return commentRepository.save(commentForm.toEntity()).getId();
    }
}
