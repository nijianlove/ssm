package com.itcast.service;

import com.itcast.domain.PageBean;
import com.itcast.domain.User;

import java.util.List;

public interface UserService {
    User login(User user) throws Exception;

    List<User> findAll(PageBean pageBean) throws Exception;

    void saveUser(User user) throws Exception;

    void updateUser(User user) throws Exception;

    User findById(Integer id) throws Exception;

    Integer findCounts(PageBean pageBean) throws Exception;

    void deleteById(Integer id) throws Exception;

    void deleteByIds(Integer[] ids) throws Exception;
}
