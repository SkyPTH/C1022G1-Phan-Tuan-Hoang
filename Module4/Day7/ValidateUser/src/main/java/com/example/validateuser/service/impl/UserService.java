package com.example.validateuser.service.impl;

import com.example.validateuser.model.User;
import com.example.validateuser.repository.IUserRepository;
import com.example.validateuser.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {
    @Autowired
    IUserRepository iUserRepository;

    @Override
    public void create(User user) {
        iUserRepository.save(user);
    }
}
