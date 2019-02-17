package com.itcast.mapper;

import com.itcast.domain.PageBean;
import com.itcast.domain.User;

import java.util.List;


public interface UserMapper {
    User login(User user) throws Exception;

    List<User> findAll(PageBean pageBean) throws Exception;

    void saveUser(User user) throws Exception;

    void updateUser(User user) throws Exception;

    User findById(Integer id) throws Exception;

    Integer findCounts(PageBean pageBean) throws Exception;

    void deleteById(Integer id) throws Exception;
}
