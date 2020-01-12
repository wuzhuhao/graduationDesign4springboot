package com.graduationaldesign.graduation.service;


import com.graduationaldesign.graduation.pojo.User;

public interface UserService {

    User getUserById(Integer id);

    User login(String username,String password);

    boolean register(User user);
    User getUserByName(String getMapByName);
}
