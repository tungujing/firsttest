package com.gxa.service;

import com.gxa.entity.User;

public interface UserSerice {
    void insert(User user);
    User login(User user);
    User getByname(String name);
}
