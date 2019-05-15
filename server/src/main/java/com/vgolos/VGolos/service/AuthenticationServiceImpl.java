package com.vgolos.VGolos.service;

import com.vgolos.VGolos.entity.Account;
import com.vgolos.VGolos.entity.Citizen;
import com.vgolos.VGolos.entity.Role;
import com.vgolos.VGolos.security.configuration.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class AuthenticationServiceImpl {

    private AuthenticationManager authenticationManager;
    private JwtTokenProvider tokenProvider;
    private AccountService accountService;
    private CitizenService citizenService;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationServiceImpl(AuthenticationManager authenticationManager,
                                     JwtTokenProvider tokenProvider,
                                     AccountService accountService,
                                     CitizenService citizenService,
                                     PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.tokenProvider = tokenProvider;
        this.accountService = accountService;
        this.passwordEncoder = passwordEncoder;
    }

    public String login(Account account) {
        return authenticate(account.getLogin(), account.getPassword());
    }

    public String register(Account account) {
        try {
            if (accountService.loginExists(account.getLogin())) {
                throw new RuntimeException("User e-mail already in "
                        + "use!");
            }
            String login = account.getLogin();
            String password = account.getPassword();
            account.setPassword(passwordEncoder.encode(password));
            if (account.isCitizen()) {
                citizenService.createCitizen((Citizen) account);
            } else {
                accountService.createAccount(account);
            }
            return authenticate(login, password);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    private String authenticate(String login, String password) {
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(
                        login, password
                );

        Authentication authentication = null;
        try {
            authentication = authenticationManager.authenticate(token);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);

        return "Bearer " + jwt;
    }
}
