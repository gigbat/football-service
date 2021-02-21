package com.dev.cinema.controller;

import com.dev.cinema.model.Role;
import com.dev.cinema.model.User;
import com.dev.cinema.service.RoleService;
import com.dev.cinema.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;

public class Injector {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public Injector(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void inject() {
        User admin = new User();
        admin.setEmail("admin@gmail.com");
        admin.setPassword("admin");

        Role role = new Role();
        role.setRole("ADMIN");
        admin.setRole(role);

        roleService.add(role);
        userService.add(admin);
    }
}
