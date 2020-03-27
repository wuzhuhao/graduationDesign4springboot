package com.graduationaldesign.graduation.service.impl;

import com.graduationaldesign.graduation.aop.RootPropeties;
import com.graduationaldesign.graduation.mapper.AdminMapper;
import com.graduationaldesign.graduation.pojo.Admin;
import com.graduationaldesign.graduation.pojo.AdminExample;
import com.graduationaldesign.graduation.pojo.UserModel;
import com.graduationaldesign.graduation.pojo.helper.ExampleHelper;
import com.graduationaldesign.graduation.service.AdminService;
import com.graduationaldesign.graduation.util.PageBean;
import com.graduationaldesign.graduation.util.ResponseStatu;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.lang.reflect.InvocationTargetException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.List;

/**
 * @Author: wuzhuhao
 * @Date: 2020/1/14 16:50
 */
@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    AdminMapper adminMapper;
    @Autowired
    RootPropeties rootPropeties;

    @Override
    public void deleteByPrimaryKeyIn(List<String> lstPrimaryKey) throws Exception {
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andAdminIdIn(lstPrimaryKey);
        adminMapper.deleteByExample(example);
    }

    @Override
    public int deleteByPrimaryKey(String adminId) {
        return adminMapper.deleteByPrimaryKey(adminId);
    }

    @Override
    public int insert(Admin record) {
        return adminMapper.insert(record);
    }

    @Override
    public int insertSelective(Admin record) {
        return adminMapper.insertSelective(record);
    }

    @Override
    public Admin selectByPrimaryKey(String adminId) {
        return adminMapper.selectByPrimaryKey(adminId);
    }

    @Override
    public int updateByPrimaryKeySelective(Admin record) {
        return adminMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Admin record) {
        return adminMapper.updateByPrimaryKey(record);
    }

    @Override
    public Admin getAdminByName(String adminID) {
        //模拟数据库查询，正常情况此处是从数据库或者缓存查询。
        return getMapByName(adminID);
    }

    @Override
    public Admin login(Admin admin) {
        AdminExample example = new AdminExample();
        AdminExample.Criteria criteria = example.createCriteria();
        criteria.andAdminIdEqualTo(admin.getAdminId());
        if (adminMapper.selectByExample(example).size() == 0) {
            throw new RuntimeException("账号不存在！");
        } else {
            criteria.andAdminPasswordEqualTo(admin.getAdminPassword());
            List<Admin> list = adminMapper.selectByExample(example);
            if (list.size() == 0) {
                throw new RuntimeException("密码错误！");
            } else {
                return list.get(0);
            }
        }
    }

    private boolean checkPassword(String id, String oldPassword) {
        Admin admin = adminMapper.selectByPrimaryKey(id);
        boolean flag = true;
        if (!admin.getAdminPassword().equals(oldPassword)) {
            flag = false;
        }
        return flag;
    }

    @Override
    public String changPassword(String id, String oldPassword, String newPassword) {
        if (!checkPassword(id, oldPassword)) {
            throw new RuntimeException("原密码不正确!");
        }
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        criteria.andAdminIdEqualTo(id);
        if (adminMapper.updateByExampleSelective(new Admin(newPassword), adminExample) > 0) {
            return "修改成功！";
        }
        return "修改失败！";
    }

    /**
     * 模拟数据库查询
     *
     * @param userName
     * @return
     */
    private Admin getMapByName(String userName) {
        //共添加两个用户，两个用户都是admin一个角色，
        //wsl有query和add权限，zhangsan只有一个query权限
//        Permissions permissions1 = new Permissions("1","query");
//        Permissions permissions2 = new Permissions("2","add");
//        Set<Permissions> permissionsSet = new HashSet<>();
//        permissionsSet.add(permissions1);
//        permissionsSet.add(permissions2);
//        Role role = new Role("1","admin",permissionsSet);
//        Set<Role> roleSet = new HashSet<>();
//        roleSet.add(role);
//        Admin user = new Admin(1,"wsl","123456",roleSet);
//        Map<String ,User> map = new HashMap<>();
//        map.put(user.getUserName(), user);
//
//        Permissions permissions3 = new Permissions("3","query");
//        Set<Permissions> permissionsSet1 = new HashSet<>();
//        permissionsSet1.add(permissions3);
//        Role role1 = new Role("2","user",permissionsSet1);
//        Set<Role> roleSet1 = new HashSet<>();
//        roleSet1.add(role1);
//        User user1 = new User(2,"zhangsan","123456",roleSet1);
//        map.put(user1.getUserName(), user1);
//        return map.get(userName);
        return null;
    }

    @Override
    public PageBean<Admin> listByPage(HashMap<String, Object> params, int page, int pageSize)
            throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, ClassNotFoundException {
        PageBean<Admin> pageBean = new PageBean<>();
        AdminExample adminExample = new AdminExample();
        AdminExample.Criteria criteria = adminExample.createCriteria();
        ExampleHelper.searchJoin(Admin.class, adminExample, criteria, params);
        ExampleHelper.addCondition(Admin.class, criteria, params);
        List<Admin> list = this.adminMapper.selectByExample(adminExample);
        pageBean.setBeanList(list);
        //pageBean.setParams(params);
        return pageBean;
    }

    private Admin getUsetById(String id) {
        Admin list = adminMapper.selectByPrimaryKey(id);
        return list;
    }

    @Override
    public String changeInformation(UserModel userModel) {
        String message;
        Admin admin = getUsetById(userModel.getId());
        if (admin == null) {
            throw new RuntimeException("账号不存在,请重新登陆！");
        }
        if (true) {
            System.out.println("哈哈哈哈");
        }
        admin.setModel(userModel);
        if (adminMapper.updateByPrimaryKey(admin) > 0) {
            message = "修改成功！";
        } else {
            message = "修改失败！";
        }
        return message;
    }

    @Override
    public Admin findById(String number) {
        return adminMapper.selectByPrimaryKey(number);
    }

    @Override
    public void insertListSelective(List<Admin> lstAdmin) throws Exception {
        for (Admin admin : lstAdmin) {
            adminMapper.insertSelective(admin);
        }
    }

    @Override
    public ResponseEntity<Object> updateListByPrimaryKeySelective(List<Admin> lstRecord) {
        String message = MessageFormat.format("批量修改{0}成功", rootPropeties.getAdmin());
        try {
            adminMapper.updateBatchByPrimaryKeySelective(lstRecord);
        } catch (Exception e) {
            e.printStackTrace();
            message = MessageFormat.format("批量修改{0}失败", rootPropeties.getAdmin());
        }
        return ResponseStatu.success(message);
    }
}
