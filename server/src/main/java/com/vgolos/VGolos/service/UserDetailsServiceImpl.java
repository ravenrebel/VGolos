package com.vgolos.VGolos.service;

import com.vgolos.VGolos.entity.Account;
import com.vgolos.VGolos.security.configuration.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    AccountService accountService;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String login)
            throws UsernameNotFoundException {
        Account account = accountService.findByLogin(login);
        if (account == null) {
             throw new UsernameNotFoundException("User with login '"
                     + login + "' not found.");
        }
        return UserDetailsImpl.create(account, account.getRole());
    }

    @Transactional
    public UserDetails loadUserById(Long id) {
        Account account = accountService.findById(id);
        if (account == null) {
            throw new UsernameNotFoundException(
                    "Account with id '" + id + "' not found."
            );
        }

        return UserDetailsImpl.create(account, account.getRole());
    }
}
