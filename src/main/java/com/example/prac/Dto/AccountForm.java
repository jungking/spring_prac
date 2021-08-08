package com.example.prac.Dto;

import com.example.prac.Domain.Account;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Data
@NoArgsConstructor
public class AccountForm {
    private Long id;
    private String username;
    private String password;
    private String role;

    public Account toEntity(){
        return Account.builder()
                .id(id)
                .username(username)
                .password(new BCryptPasswordEncoder().encode(password))
                .role(role)
                .build();
    }

    @Builder
    public AccountForm(Long id, String username,String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }


}
