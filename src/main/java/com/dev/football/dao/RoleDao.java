package com.dev.football.dao;

import com.dev.football.model.Role;
import java.util.Optional;

public interface RoleDao {
    void add(Role role);

    Optional<Role> getRoleByName(String roleName);
}
