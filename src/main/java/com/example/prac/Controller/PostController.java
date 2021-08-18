package com.example.prac.Controller;

import com.example.prac.Dto.PostForm;
import com.example.prac.Service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post")
    public String GetPost(Model model){
        System.out.println("getPosting page");
        List<PostForm> postList = postService.getPostList();
        model.addAttribute("postList",postList);
        return "/post/post";
    }

    @PostMapping("/post")
    public String PostPost(){
        System.out.println("post post ");
        return "post";
    }

    @GetMapping("/post/edit")
    public String GetUploadPosting(){
        System.out.println("get upload post");
        return "/post/edit";
    }

    @PostMapping("/post/edit")
    public String PostUploadPosting(PostForm postForm) {
        System.out.println("post upload post");
        postService.save(postForm);
        return "redirect:/post";
    }

    @PostMapping("/post/{id}")
    public String PostDelete(@PathVariable("id") long id) throws Exception{
        postService.postDelete(id);
        return "redirect:/post";
    }

    @GetMapping("/post/sujung/{id}")
    public String GetUpdate(@PathVariable("id") Long id, Model model) {
        System.out.println("get update post");
        PostForm postForm = postService.getPost(id);
        model.addAttribute("postList",postForm);
        return "redirect:/post/sujung";
    }

    @PutMapping("/post/sujung/{id}")
    public String PostUpdate(@PathVariable("id") long id, PostForm postForm) {
        System.out.println("post update post");
        postForm.setId(id);
        postService.save(postForm);
        return "redirect:../";
    }

}
