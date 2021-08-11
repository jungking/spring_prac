package com.example.prac.Controller;

import com.example.prac.Dto.AccountForm;
import com.example.prac.Service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
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
    private final AccountService accountService;

    @GetMapping("/signup")
    public String createUserForm(){
        System.out.println("get registerUser");
        return "signup";
    }

    @PostMapping("/signup")
    public String createUser(AccountForm form){
        System.out.println("post registerUser");
        accountService.save(form);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String getLogin(){
        System.out.println("get Login");
        return "login";
    }

    @PostMapping("/login")
    public String postLogin(@AuthenticationPrincipal AccountForm accountForm, Model model){
        System.out.println(accountForm);

        model.addAttribute("member",accountForm);
        return "redirect:/";
    }


    @GetMapping("/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/";
    }
}
