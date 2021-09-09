package com.example.prac.Controller;

import com.example.prac.Domain.Account;
import com.example.prac.Dto.AccountForm;
import com.example.prac.Service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor
public class UserController {
    private Account account;
    private final AccountService accountService;

    @GetMapping("/signup")
    public String createUserForm(){
        return "signup";
    }

    @PostMapping("/signup")
    public String createUser(AccountForm form, Model model)throws Exception{
        try {
            accountService.save(form);
            model.addAttribute("message","회원가입 성공");
            model.addAttribute("href","/signup");
            System.out.println("Success : Sign Up1");

        }catch(NullPointerException e){
            model.addAttribute("message","회원가입 실패");
            model.addAttribute("href","/signup");
            System.out.println("Success : Sign Up2");

        }
        return "redirect:message";
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
