package com.example.riotshop_api.repository;

import com.example.riotshop_api.model.AccountUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAccountUserRepository extends JpaRepository<AccountUser,Integer> {
    AccountUser findAccountUserByNameAccount(String username);
    boolean existsAccountUserByNameAccount(String name);
}
