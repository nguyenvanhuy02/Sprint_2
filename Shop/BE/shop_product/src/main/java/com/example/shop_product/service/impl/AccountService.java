package com.example.shop_product.service.impl;

import com.example.shop_product.model.account.Account;
import com.example.shop_product.repository.account.IAccountRepository;
import com.example.shop_product.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountService implements IAccountService {

    @Autowired
    private IAccountRepository accountRepository;

    @Override
    public Account findAccountByUsername(String username) {
        return accountRepository.findAccountByUsername(username);
    }
}
