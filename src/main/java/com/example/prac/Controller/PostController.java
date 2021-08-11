package com.example.prac.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PostController {

    @PostMapping("/post")
    public String GetPost(){
        System.out.println("getPosting page");
        return "post";
    }
}
