package com.example.riotshop_api.service;

import com.example.riotshop_api.model.Role;

public interface IRoleService {
    Role findbyNameRole(String name);
}
