package com.example.prac.Controller;

import com.example.prac.Domain.CommentEntity;
import com.example.prac.Domain.PostEntity;
import com.example.prac.Repository.CommentRepository;
import com.example.prac.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CommentController {
    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/post/read/{id}/comment")
    public List<CommentEntity> getPostComments(@PathVariable Long id){
        PostEntity postEntity = postRepository.findById(id).get();
        return commentRepository.findCommentsByPostEntity(postEntity);
    }

    @PutMapping("/post/read/{id}/comment")
    public CommentEntity createComment(@PathVariable Long id, @RequestBody CommentEntity commentEntity){
        Optional<PostEntity> postItem = postRepository.findById(id);
        commentEntity.setPostEntity(postItem.get());
        commentRepository.save(commentEntity);
        return commentEntity;
    }

    @PostMapping("post/read/{id}/comment/{commentID}")
    public CommentEntity updateComment(@PathVariable Long id,@PathVariable Long commentID, @RequestBody CommentEntity commentEntity){
        Optional<PostEntity> postItem = postRepository.findById(id);
        //CommentEntity.setPost(postItem.get());
        CommentEntity newComment = commentRepository.findById(commentID).get();
        newComment.setTitle(commentEntity.getTitle());
        newComment.setContent(commentEntity.getContent());
        newComment.setUserid(commentEntity.getUserid());
        return newComment;
    }

    @DeleteMapping("/post/read/{id}/comment/{commentID}")
    public String deleteComment(@PathVariable Long id, @PathVariable Long commentID){
        //commentRepository.deleteByID(id);
        return "delete success";
    }
}
