package com.gxa.service.impl;

import com.gxa.entity.User;
import com.gxa.mapper.UserMapper;
import com.gxa.service.UserSerice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service   //就是bean Component
public class UserServiceImpl implements UserSerice {

    @Autowired
    //@Qualifier("")
    private UserMapper userMapper;

    @Transactional  //事务操作
    @Override
    public void insert(User user) {
        this.userMapper.insert(user);
    }

    @Override
    public User login(User user) {
        User selectUser = this.userMapper.getUserByNameAndId(user);

        return selectUser;
    }

    @Override
    public User getByname(String name) {
        User byname = this.userMapper.getByname(name);
        return byname;
    }
}
