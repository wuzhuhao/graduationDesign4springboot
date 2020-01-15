package com.graduationaldesign.graduation.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.graduationaldesign.graduation.mapper.RoleMapper;
import com.graduationaldesign.graduation.pojo.Role;
import com.graduationaldesign.graduation.service.ITRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graduationaldesign.graduation.util.SqlUtil;

@Service
public class TRoleService implements ITRoleService {
//    @Resource(name="RoleMapper")
    @Autowired
    private RoleMapper tRoleMapper;
//
//    @Override
//    public boolean save(Role tRole) {
//        return tRoleMapper.insert(tRole) > 0;
//    }
//
//    @Override
//    public boolean update(Role tRole) {
//        return tRoleMapper.updateByPrimaryKeySelective(tRole) >= 0;
//    }
//
//    @Override
//    public boolean delete(Long id) {
//        return tRoleMapper.deleteByPrimaryKey(id) > 0;
//    }
//
//    @Override
//    public boolean batchDelete(Long[] primaryKeys) {
//        return tRoleMapper.deleteByPrimaryKeys(primaryKeys) > 0;
//    }
//
//    @Override
//    public Role findModel(Long id) {
//        return tRoleMapper.selectByPrimaryKey(id);
//    }
//
//    @Override
//    public Role findModel(Long id, String[] parameters) {
//        return tRoleMapper.findModel(id, SqlUtil.formatParameters(parameters));
//    }
//
//    public Map<String, Object> findMap(Long id) {
//        String[][] parameters = {{"id", "id"}, {"role_name", "roleName"}, {"role_desc", "roleDesc"}};
//        return this.findMap(id, parameters);
//    }
//
//    public Map<String, Object> findMap(Long id, String[][] parameters) {
//        return tRoleMapper.findMap(id, SqlUtil.formatParametersForAlias(parameters));
//    }
//
//    @Override
//    public List<Role> loadModels() {
//        return this.loadModels(null, null, null, null, -1, -1);
//    }
//
//    @Override
//    public List<Role> loadModels(String condition, Object[] values, String order, String sort, int curPage, int limit) {
//        return this.loadModels(null, condition, values, order, sort, curPage, limit);
//    }
//
//    @Override
//    public List<Role> loadModels(String[] parameters, String condition, Object[] values, String order, String sort, int curPage, int limit) {
//        return tRoleMapper.loadModels(SqlUtil.formatParameters(parameters), SqlUtil.fillCondition(condition, values), order, sort, SqlUtil.getOffset(curPage, limit), limit);
//    }
//
//    @Override
//    public List<Map<String, Object>> loadMaps() {
//        String[][] parameters = {{"id", "id"}, {"role_name", "roleName"}, {"role_desc", "roleDesc"}};
//        return this.loadMaps(parameters, null, null, null, null, -1, -1);
//    }
//
//    @Override
//    public List<Map<String, Object>> loadMaps(String condition, Object[] values, String order, String sort, int curPage, int limit) {
//        String[][] parameters = {{"id", "id"}, {"role_name", "roleName"}, {"role_desc", "roleDesc"}};
//        return this.loadMaps(parameters, condition, values, order, sort, curPage, limit);
//    }
//
//    @Override
//    public List<Map<String, Object>> loadMaps(String[][] parameters, String condition, Object[] values, String order, String sort, int curPage, int limit) {
//        return tRoleMapper.loadMaps(SqlUtil.formatParametersForAlias(parameters), SqlUtil.fillCondition(condition, values), order, sort, SqlUtil.getOffset(curPage, limit), limit);
//    }
//
//    @Override
//    public long count() {
//        return this.count(null, false);
//    }
//
//    @Override
//    public long count(String condition, Object[] values) {
//        return this.count(null, condition, values, false);
//    }
//
//    @Override
//    public long count(String[] parameters, boolean isDistinct) {
//        return this.count(parameters, null, null, isDistinct);
//    }
//
//    @Override
//    public long count(String[] parameters, String condition, Object[] values, boolean isDistinct) {
//        return tRoleMapper.count(SqlUtil.formatParameters(parameters), SqlUtil.fillCondition(condition, values), isDistinct);
//    }

}
