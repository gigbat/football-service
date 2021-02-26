package com.dev.football.dao;

import com.dev.football.model.User;
import java.util.Optional;

public interface UserDao {
    User add(User user);

    Optional<User> findByEmail(String email);

    Optional<User> get(Long id);
}
