package com.dev.football.service;

import com.dev.football.model.Role;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(String roleName);
}
