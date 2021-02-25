package com.dev.football.controller;

import com.dev.football.model.Role;
import com.dev.football.model.User;
import com.dev.football.service.RoleService;
import com.dev.football.service.UserService;
import java.util.Set;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final UserService userService;
    private final RoleService roleService;

    @Autowired
    public DataInitializer(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostConstruct
    private void inject() {
        User admin = new User();
        admin.setEmail("admin@gmail.com");
        admin.setPassword("admin");

        Role adminRole = new Role();
        adminRole.setRole("ADMIN");
        admin.setRole(Set.of(adminRole));

        Role userRole = new Role();
        userRole.setRole("USER");

        roleService.add(adminRole);
        roleService.add(userRole);
        userService.add(admin);
    }
}
