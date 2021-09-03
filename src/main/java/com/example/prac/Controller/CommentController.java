package com.example.prac.Controller;

import com.example.prac.Domain.CommentEntity;
import com.example.prac.Domain.PostEntity;
import com.example.prac.Dto.CommentForm;
import com.example.prac.Repository.CommentRepository;
import com.example.prac.Repository.PostRepository;
import com.example.prac.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class CommentController {
    private final CommentService commentService;

    @Autowired
    PostRepository postRepository;

    @Autowired
    CommentRepository commentRepository;

    public CommentController(CommentService commentService) { this.commentService = commentService;}

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
        //commentRepository.save(commentForm.toEntity());
        commentService.save(commentForm);
        return "redirect:/post/read/{id}";
    }

    @PutMapping("post/read/{id}/comment/update/{commentID}")        //댓글 수정 기능
    public String updateComment(@PathVariable Long id,@PathVariable Long commentID, CommentForm commentForm){
        Optional<PostEntity> postItem = postRepository.findById(id);
        commentForm.setPostEntity(postItem.get());

        commentForm.setId(commentID);
        commentService.update(commentForm);
        return "redirect:/post/read/{id}";
    }

    @DeleteMapping("/post/read/{id}/comment/delete/{commentID}")        //댓글 삭제 기능
    public String deleteComment(@PathVariable Long id, @PathVariable Long commentID){
        commentService.deleteByID(commentID);
        return "redirect:/post/read/{id}";
    }
}
