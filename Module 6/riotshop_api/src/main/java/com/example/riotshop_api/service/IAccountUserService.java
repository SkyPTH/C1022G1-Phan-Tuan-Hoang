package com.example.riotshop_api.service;

import com.example.riotshop_api.model.AccountUser;

public interface IAccountUserService {
    AccountUser findAccountUserByNameAccount(String username);
    boolean isAccountUserExistByName(String name);
    AccountUser save(AccountUser accountUser);
}
