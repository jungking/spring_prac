package com.example.prac.Dto;

import lombok.*;

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