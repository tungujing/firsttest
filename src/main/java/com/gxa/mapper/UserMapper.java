package com.gxa.mapper;

import com.gxa.entity.User;

public interface UserMapper {
    void insert(User user);
    User getUserByNameAndId(User user);
    User getByname(String name);
}
