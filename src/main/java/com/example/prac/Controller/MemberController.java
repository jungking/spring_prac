package com.example.prac.Controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberController {

    @GetMapping("/hello")
    public String hello(){
        System.out.println("halloo");
        return "hello!!";
    }
}
