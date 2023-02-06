package com.project.ecom.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.project.ecom.model.Account;
import com.project.ecom.service.AccountService;

import java.util.List;

import java.util.Optional;

@RestController
@RequestMapping(value = "/account")
public class AccountController {

    @Autowired
    private AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping()
    public List<Account> getAllAccount() {

        return accountService.getAllAccount();
    }

    
    
    

    @PostMapping()
    public String addAccount(@RequestBody Account account) {

        accountService.addAccount(account);
        return "Account is created.";
    }

    @GetMapping("/{id}")
    public Optional<Account> getAccount(@PathVariable("id")int id) {

        return accountService.getAccountById(id);
    }

    @PutMapping("/{id}")
    public String updateAccount(@PathVariable("id")int id, @RequestBody Account account) {

        accountService.updateAccount(id, account);
        return "Account is updated.";
    }

    @DeleteMapping("/{id}")
    public String deleteAccountById(@PathVariable("id")int id) {

        accountService.deleteAccountById(id);

        return "Account with Account Number " + id + " successfully deleted.";
    }


}