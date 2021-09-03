package com.showrav.bonik.service;

import com.showrav.bonik.domain.User;

public interface UserService {
    void save(User user);
    void login(String username, String password);
    User findByUsername(String username);
    User findByEmail(String email);
    User findById(long id);
}
