package com.shin.MiniList.controller;

import com.shin.MiniList.model.Users;
import com.shin.MiniList.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @Autowired
    private UserService service;

    @PostMapping("/register")
    public Users register(@RequestBody Users users) {
        return service.register(users);
    }

    @PostMapping("/login")
    public String login(@RequestBody Users users) {
        return service.verify(users);
    }

}
