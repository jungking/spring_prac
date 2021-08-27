package com.example.prac.Controller;

import com.example.prac.Domain.CommentEntity;
import com.example.prac.Domain.PostEntity;
import com.example.prac.Dto.PostForm;
import com.example.prac.Repository.CommentRepository;
import com.example.prac.Repository.PostRepository;
import com.example.prac.Service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Objects;

@Controller
public class PostController {
    private final PostService postService;
    HttpSession session;
    String user;
    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentRepository commentRepository;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post")
    public String GetPost(Model model){
        List<PostForm> postList = postService.getPostList();
        model.addAttribute("postList",postList);
        return "/post/post";
    }
    @PostMapping("/post")
    public String PostPost(){

        return "post";
    }

     @GetMapping("/post/edit")
    public String GetUploadPosting(){
        return "/post/edit";
    }

    @PostMapping("/post/edit")
    public String PostUploadPosting(PostForm postForm) {
        postService.save(postForm);
        return "redirect:/post";
    }

    @GetMapping("/post/read/{id}")
    public String PostRead(@PathVariable("id") long id, Model model) throws Exception{
        PostForm postForm = postService.getPost(id);

        PostEntity postEntity = postRepository.findById(id).get();
        List<CommentEntity> commentEntityList= commentRepository.findCommentsByPostEntity(postEntity);

        model.addAttribute("postRead", postForm);
        model.addAttribute("commentList",commentEntityList);
        user = postForm.getUserid();
        return "/post/read";
    }

    @GetMapping("/post/delete/{id}")
    public String PostDelete(@PathVariable("id") long id, HttpServletRequest request) throws Exception{
        if(!user.equals(request.getSession().getAttribute("userid"))){
            System.out.println("아이디가 다름");
            return "redirect:/post";
        }
        else{
            postService.postDelete(id);
            return "redirect:/post";
        }
    }

    @GetMapping("/post/update/{id}")
    public String GetUpdate(@PathVariable("id") Long id, Model model, HttpServletRequest request) {
        if(!user.equals(request.getSession().getAttribute("userid"))){
            System.out.println("아이디가 다름");
            return "redirect:/post";
        }
        else {
            PostForm postForm = postService.getPost(id);
            model.addAttribute("postList", postForm);
            return "/post/update";
        }
    }
    @PutMapping("/post/update/{id}")
    public String PostUpdate(@PathVariable("id") long id, PostForm postForm) {
        postForm.setId(id);
        postService.save(postForm);
        return "redirect:/post";
    }
}
