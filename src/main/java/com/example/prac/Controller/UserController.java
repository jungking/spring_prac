package com.example.prac.Controller;

import com.example.prac.Dto.AccountForm;
import com.example.prac.Service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.*;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final AccountService accountService;

    @GetMapping("/loginUser")
    public String createUserForm(Model model){
        model.addAttribute("userForm", new AccountForm());
        return "user/login/register";
    }


    @PostMapping("/loginUser")
    public String createUser(@Valid AccountForm form, BindingResult result){
        if(result.hasErrors()){
            return "user/login/register";
        }
        accountService.createUser(form);

        return "redirectL/";

    }
}
