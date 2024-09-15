package com.sjala.ecomproj.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sjala.ecomproj.model.LoginUser;
import com.sjala.ecomproj.service.UserService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class UserController {

    @Autowired
    private UserService service;


    @PostMapping("/register")
    public LoginUser register(@RequestBody LoginUser user) {
        return service.register(user);

    }
}
