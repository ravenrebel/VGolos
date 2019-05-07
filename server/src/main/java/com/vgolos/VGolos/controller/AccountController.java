package com.vgolos.VGolos.controller;

import com.vgolos.VGolos.entity.Account;
import com.vgolos.VGolos.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/accounts")
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    public ResponseEntity<List<Account>> findAll() {
        List<Account> accounts = accountService.findAll();
        return new ResponseEntity<>(accounts, HttpStatus.OK);
    }

    @GetMapping("/login/{login}")
    public ResponseEntity<Account> findByLogin(@PathVariable String login) {
        return new ResponseEntity<>(accountService.findByLogin(login),
                HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Account> create(@RequestBody Account account) {
        Account createdAccount = accountService.createAccount(account);
        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Account> update(@RequestBody Account account) {
        return new ResponseEntity<>(accountService.update(account),
                HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        accountService.deleteById(id);
    }




}
