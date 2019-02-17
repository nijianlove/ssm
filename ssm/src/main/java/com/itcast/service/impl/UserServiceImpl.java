package com.itcast.service.impl;

import com.itcast.domain.PageBean;
import com.itcast.domain.User;
import com.itcast.mapper.UserMapper;
import com.itcast.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) throws Exception{
        return userMapper.login(user);
    }

    @Override
    public List<User> findAll(PageBean pageBean) throws Exception {
        return userMapper.findAll(pageBean);
    }

    @Override
    public void saveUser(User user) throws Exception {
        userMapper.saveUser(user);
    }

    @Override
    public void updateUser(User user) throws Exception {
        userMapper.updateUser(user);
    }

    @Override
    public User findById(Integer id) throws Exception {
        return userMapper.findById(id);
    }

    @Override
    public Integer findCounts(PageBean pageBean) throws Exception {
        return userMapper.findCounts(pageBean);
    }

    @Override
    public void deleteById(Integer id) throws Exception {
            userMapper.deleteById(id);
    }

    @Override
    public void deleteByIds(Integer[] ids) throws Exception {
        for (Integer id : ids) {
            userMapper.deleteById(id);
        }
    }
}
