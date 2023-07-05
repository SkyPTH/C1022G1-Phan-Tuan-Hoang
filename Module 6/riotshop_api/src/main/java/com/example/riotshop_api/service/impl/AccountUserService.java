package com.example.riotshop_api.service.impl;

import com.example.riotshop_api.model.AccountUser;
import com.example.riotshop_api.repository.IAccountUserRepository;
import com.example.riotshop_api.service.IAccountUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountUserService implements IAccountUserService {
    @Autowired
    private IAccountUserRepository iAccountUserRepository;

    @Override
    public AccountUser findAccountUserByNameAccount(String username) {
        return iAccountUserRepository.findAccountUserByNameAccount(username);
    }

    @Override
    public boolean isAccountUserExistByName(String name) {
        return iAccountUserRepository.existsAccountUserByNameAccount(name);
    }

    @Override
    public AccountUser save(AccountUser accountUser) {
        return iAccountUserRepository.save(accountUser);
    }
}
