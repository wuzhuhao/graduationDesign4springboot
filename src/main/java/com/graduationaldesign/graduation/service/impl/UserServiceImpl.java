package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.mapper.UserMapper;
import com.graduationaldesign.graduation.pojo.Permissions;
import com.graduationaldesign.graduation.pojo.Role;
import com.graduationaldesign.graduation.pojo.User;
import com.graduationaldesign.graduation.pojo.UserExample;
import com.graduationaldesign.graduation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;

    @Override
    public User getUserById(Integer id) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andIdEqualTo(id);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList != null) {
            return userList.get(0);
        }
        return null;
    }
    @Override
    public User getUserByName(String getMapByName) {
        //模拟数据库查询，正常情况此处是从数据库或者缓存查询。
        return getMapByName(getMapByName);
    }

    /**
     * 模拟数据库查询
     * @param userName
     * @return
     */
    private User getMapByName(String userName){
        //共添加两个用户，两个用户都是admin一个角色，
        //wsl有query和add权限，zhangsan只有一个query权限
        Permissions permissions1 = new Permissions("1","query");
        Permissions permissions2 = new Permissions("2","add");
        Set<Permissions> permissionsSet = new HashSet<>();
        permissionsSet.add(permissions1);
        permissionsSet.add(permissions2);
        Role role = new Role("1","admin",permissionsSet);
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(role);
        User user = new User(1,"wsl","123456",roleSet);
        Map<String ,User> map = new HashMap<>();
        map.put(user.getUserName(), user);

        Permissions permissions3 = new Permissions("3","query");
        Set<Permissions> permissionsSet1 = new HashSet<>();
        permissionsSet1.add(permissions3);
        Role role1 = new Role("2","user",permissionsSet1);
        Set<Role> roleSet1 = new HashSet<>();
        roleSet1.add(role1);
        User user1 = new User(2,"zhangsan","123456",roleSet1);
        map.put(user1.getUserName(), user1);
        return map.get(userName);
    }

    @Override
    public User login(String username, String password) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(username);
        criteria.andPasswdEqualTo(password);
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList.size()==1){
            return userList.get(0);
        }
        return null;
    }

    @Override
    public boolean register(User user) {
        //设置可用
        user.setState(1);
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
        criteria.andUserNameEqualTo(user.getUserName());
        List<User> userList = userMapper.selectByExample(userExample);
        if (userList.size()>=1){
            return false;
        }
        if (userMapper.insert(user)==1){
            return true;
        }
        return false;
    }
}
