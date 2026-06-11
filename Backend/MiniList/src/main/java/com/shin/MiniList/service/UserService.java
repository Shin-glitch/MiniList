package com.shin.MiniList.service;

import com.shin.MiniList.model.Users;
import com.shin.MiniList.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo repo;

    public Users register(Users users) {
        return repo.save(users);
    }

}
