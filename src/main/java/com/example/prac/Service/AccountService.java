package com.example.prac.Service;

import com.example.prac.Domain.Account;
import com.example.prac.Dto.AccountForm;
import com.example.prac.Repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;
import java.io.IOException;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountService implements UserDetailsService{

    private final AccountRepository accountRepository;

    @Override
    public Account loadUserByUsername(String username) throws UsernameNotFoundException {
        return accountRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(username));
    }

    public Long save(AccountForm accountForm) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        accountForm.setPassword(encoder.encode(accountForm.getPassword()));

        return accountRepository.save(Account.builder()
                .username(accountForm.getUsername())
                .role(accountForm.getRole())
                .password(accountForm.getPassword()).build()).getId();
    }


}
