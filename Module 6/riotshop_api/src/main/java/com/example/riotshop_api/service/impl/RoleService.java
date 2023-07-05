package com.example.riotshop_api.service.impl;

import com.example.riotshop_api.model.Role;
import com.example.riotshop_api.repository.IRoleRepository;
import com.example.riotshop_api.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService implements IRoleService {
    @Autowired private IRoleRepository iRoleRepository;

    @Override
    public Role findbyNameRole(String name) {
        return iRoleRepository.findByNameRole(name);
    }
}
