package com.example.riotshop_api.repository;

import com.example.riotshop_api.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IRoleRepository extends JpaRepository<Role,Integer> {
    Role findByNameRole(String name);
}
