package com.example.shop_product.service;


import com.example.shop_product.model.account.Account;

public interface IAccountService {

    Account findAccountByUsername(String username);
}
