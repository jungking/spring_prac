package com.example.prac.Controller;

import com.example.prac.Service.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PostController {
    public PostService postservice;

    @GetMapping("/post")
    public String GetPost(){
        System.out.println("getPosting page");
        return "post";
    }



}
