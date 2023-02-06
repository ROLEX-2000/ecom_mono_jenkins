	package com.project.ecom.service;


import org.springframework.stereotype.Service;

import com.project.ecom.model.Account;
import com.project.ecom.model.Address;
import com.project.ecom.repository.AccountRepository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void addAccount(Account account) {

        accountRepository.save(account);
    }

    public Optional<Account> getAccountById(int id) {

        return accountRepository.findById(id);
    }

    public void updateAccount(int id, Account account) {

        accountRepository.save(account);
    }
    
 
   
    
    public void deleteAccountById(int id) {

        accountRepository.deleteById(id);
    }

    public List<Account> getAllAccount() {

        return accountRepository.findAll();
    }

    public Set<Address> getAddressByAccountId( int accountId) {

      
		Account account = accountRepository.getOne(accountId);

        return account.getAddresses();

    }

}
