package com.example.prac.Controller;

import com.example.prac.Dto.AccountForm;
import com.example.prac.Service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final AccountService accountService;

    @GetMapping("/signup")
    public String createUserForm(){
        return "signup";
    }

    @PostMapping("/signup")
    public String createUser(AccountForm form){
        accountService.save(form);
        System.out.println("Success : Sign Up");
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLogin(){
        return "/login";
    }

    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        System.out.println("Success : Log Out");
        return "redirect:/";
    }
}
