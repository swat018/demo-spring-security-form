package com.example.demospringsecurityform.form;

import com.example.demospringsecurityform.account.Account;
import com.example.demospringsecurityform.account.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.test.context.support.WithMockUser;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SampleServiceTest {

    @Autowired
    SampleService sampleService;

    @Autowired
    AccountService accountService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Test
//    @WithMockUser
    public void dashboard() {
        Account account = new Account();
        account.setRole("ADMIN");
        account.setUsername("jinwoo");
        account.setPassword("123");
        accountService.createNew(account);

        UserDetails userDetails = accountService.loadUserByUsername("jinwoo");

        UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, "123");
        Authentication authenticate = authenticationManager.authenticate(token);


        SecurityContextHolder.getContext().setAuthentication(authenticate);

        sampleService.dashboard();
    }

}