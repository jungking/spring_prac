package com.example.prac.Service;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyLoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                HttpServletResponse response, Authentication authentication)
                throws IOException, ServletException {
        HttpSession session = request.getSession();
        System.out.println("Success : Log In");
        session.setAttribute("userid", authentication.getName());
        session.setAttribute("message","회원가입 성공");
        session.setAttribute("href","/signup");
        response.sendRedirect("message");
    }
}
