package com.example.prac.Controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@AllArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String index() {
        System.out.println("main");
        return "main";
    }

}
