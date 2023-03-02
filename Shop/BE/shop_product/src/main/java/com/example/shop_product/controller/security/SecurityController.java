package com.example.shop_product.controller.security;


import com.example.shop_product.dto.request.LoginForm;
import com.example.shop_product.dto.respone.JwtRespone;
import com.example.shop_product.security.jwt.JwtProvider;
import com.example.shop_product.security.user.MyUserDetail;
import com.example.shop_product.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/clothes")
public class SecurityController {

    @Autowired
    private IAccountService accountService;
    @Autowired
    private JwtProvider jwtProvider;
    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping("/login")
    public ResponseEntity<?> login(@Validated @RequestBody LoginForm loginForm,
                                   BindingResult bindingResult) {


        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginForm.getUserName(), loginForm.getPassword()));

        MyUserDetail myUserDetail = (MyUserDetail) authentication.getPrincipal();

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtProvider.createToken(authentication);

        return new ResponseEntity<>(new JwtRespone(token,
                myUserDetail.getAuthorities(),
                myUserDetail.getAccount(),
                myUserDetail.getAccount().getUser()), HttpStatus.OK);
    }
}
