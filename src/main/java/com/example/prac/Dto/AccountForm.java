package com.example.prac.Dto;

import com.example.prac.Domain.Account;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Collection;

@Data
@NoArgsConstructor
@Getter
@Setter
public class AccountForm {
    private Long id;
    private String username;
    private String password;
    private String role;

    @Builder
    public AccountForm(Long id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

}