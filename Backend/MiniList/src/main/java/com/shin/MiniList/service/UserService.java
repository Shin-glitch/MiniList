package com.shin.MiniList.service;

import com.shin.MiniList.model.Users;
import com.shin.MiniList.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

    public Users register(Users users) {

        users.setPassword(encoder.encode(users.getPassword()));

        return repo.save(users);
    }

}
