package com.vgolos.VGolos.service;

import com.vgolos.VGolos.entity.Account;
import com.vgolos.VGolos.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account findByLogin(String login) {
        return accountRepository.findByLogin(login).get();
    }

    public Account createAccount(Account account) {
        account.setId(-1L);
        account.setRoles(new HashSet<>());
        Account createdAccount = accountRepository.save(account);
        return createdAccount;
    }

    public Account update(Account account) {
        Account existingAccount = accountRepository.findById(account.getId()).get();
        if (account.getRoles() != null ) {
            existingAccount.setRoles(account.getRoles());
        }
        return accountRepository.save(existingAccount);
    }

    public void deleteById(Long id) {
        accountRepository.deleteById(id);
    }
}
