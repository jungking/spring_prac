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
        model.addAttribute("postRead", postForm);
        return "/post/read";
    }

    @PostMapping("/post/delete/{id}")
    public String PostDelete(@PathVariable("id") long id) throws Exception{
        postService.postDelete(id);
        return "redirect:/post";
    }

    @GetMapping("/post/update/{id}")
    public String GetUpdate(@PathVariable("id") Long id, Model model) {
        PostForm postForm = postService.getPost(id);
        model.addAttribute("postList",postForm);
        return "/post/update";
    }
    @PutMapping("/post/update/{id}")
    public String PostUpdate(@PathVariable("id") long id, PostForm postForm) {
        postForm.setId(id);
        postService.save(postForm);
        return "redirect:/post";
    }
}
