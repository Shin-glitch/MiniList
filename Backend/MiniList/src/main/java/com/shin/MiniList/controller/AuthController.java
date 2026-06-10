package com.shin.MiniList.controller;

import com.shin.MiniList.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @PostMapping("/register")
    public String register(@RequestBody User user) {
        return "success";
    }
}
