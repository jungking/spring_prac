package com.example.prac.Controller;

import com.example.prac.Domain.CommentEntity;
import com.example.prac.Domain.PostEntity;
import com.example.prac.Dto.CommentForm;
import com.example.prac.Dto.PostForm;
import com.example.prac.Repository.CommentRepository;
import com.example.prac.Repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Controller
public class CommentController {
    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    @GetMapping("/post/read/{id}/comment") //json으로 넘어옴
    public void getPostComments(@PathVariable Long id, Model model){
        PostEntity postEntity = postRepository.findById(id).get();
        List<CommentEntity> commentEntityList= commentRepository.findCommentsByPostEntity(postEntity);
        model.addAttribute("commentList", commentEntityList);
    }

    @PostMapping("/post/read/{id}/comment/create")
    public String createComment(@PathVariable Long id, CommentForm commentForm){
        Optional<PostEntity> postItem = postRepository.findById(id);
        commentForm.setPostEntity(postItem.get());
        commentRepository.save(commentForm.toEntity()).getId();
        System.out.println(commentForm.getPostEntity());
        return "redirect:/post/read/{id}";
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
