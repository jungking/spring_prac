package com.example.prac.Service;

import com.example.prac.Domain.Account;
import com.example.prac.Dto.AccountForm;
import com.example.prac.Repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional()
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    @Transactional
    public Long createUser(AccountForm form){
        Account account = form.toEntity();
        accountRepository.save(account);
        return account.getId();
    }
}
