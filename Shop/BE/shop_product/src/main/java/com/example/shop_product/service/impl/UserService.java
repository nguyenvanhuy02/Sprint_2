package com.example.shop_product.service.impl;

import com.example.shop_product.model.user.User;
import com.example.shop_product.repository.user.IUserRepository;
import com.example.shop_product.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    private IUserRepository userRepository;


    @Override
    public User getUserById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }
}
