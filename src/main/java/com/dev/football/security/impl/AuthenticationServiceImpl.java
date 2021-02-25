package com.dev.football.security.impl;

import com.dev.football.model.Role;
import com.dev.football.model.User;
import com.dev.football.security.AuthenticationService;
import com.dev.football.service.RoleService;
import com.dev.football.service.ShoppingCartService;
import com.dev.football.service.UserService;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    private final UserService userService;
    private final ShoppingCartService shoppingCartService;
    private final RoleService roleService;

    @Autowired
    public AuthenticationServiceImpl(UserService userService,
                                     ShoppingCartService shoppingCartService,
                                     RoleService roleService) {
        this.userService = userService;
        this.shoppingCartService = shoppingCartService;
        this.roleService = roleService;
    }

    @Override
    public User register(String email, String password) {
        User user = new User();
        user.setEmail(email);
        user.setPassword(password);
        Role roleUser = roleService.getRoleByName("USER");
        Set<Role> rolesUser = new HashSet<>();
        rolesUser.add(roleUser);
        user.setRole(rolesUser);
        User userOld = userService.add(user);
        shoppingCartService.registerNewShoppingCart(userOld);
        return userOld;
    }
}
