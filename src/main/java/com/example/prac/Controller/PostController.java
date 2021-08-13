package com.example.prac.Controller;

import com.example.prac.Dto.PostForm;
import com.example.prac.Service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping("/post")
    public String GetPost(){
        System.out.println("getPosting page");
        return "post";
    }

    @PostMapping("/post")
    public String PostPost(){
        System.out.println("post post ");
        return "post";
    }

    @GetMapping("/upload")
    public String GetUploadPosting(){
        System.out.println("get upload post");
        return "upload";
    }

    @PostMapping("/upload")
    public String PostUploadPosting(PostForm postForm) {
        System.out.println("post upload post");
        System.out.println(postForm.getTitle());
        System.out.println( postForm.getContent());
        System.out.println(postForm.getUserid());

        postService.save(postForm);
        return "redirect:post";
    }
}
