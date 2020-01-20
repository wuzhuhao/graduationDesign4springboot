package com.graduationaldesign.graduation.mapper;

import com.graduationaldesign.graduation.pojo.RolePermission;
import com.graduationaldesign.graduation.pojo.RolePermissionExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface RolePermissionMapper {
    /**
     *  根据指定的条件获取数据库记录数,t_role_permission
     *
     * @param example
     */
    long countByExample(RolePermissionExample example);

    /**
     *  根据指定的条件删除数据库符合条件的记录,t_role_permission
     *
     * @param example
     */
    int deleteByExample(RolePermissionExample example);

    /**
     *  根据主键删除数据库的记录,t_role_permission
     *
     * @param id
     */
    int deleteByPrimaryKey(Long id);

    /**
     *  新写入数据库记录,t_role_permission
     *
     * @param record
     */
    int insert(RolePermission record);

    /**
     *  动态字段,写入数据库记录,t_role_permission
     *
     * @param record
     */
    int insertSelective(RolePermission record);

    /**
     *  根据指定的条件查询符合条件的数据库记录,t_role_permission
     *
     * @param example
     */
    List<RolePermission> selectByExample(RolePermissionExample example);

    /**
     *  根据指定主键获取一条数据库记录,t_role_permission
     *
     * @param id
     */
    RolePermission selectByPrimaryKey(Long id);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,t_role_permission
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") RolePermission record, @Param("example") RolePermissionExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,t_role_permission
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") RolePermission record, @Param("example") RolePermissionExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,t_role_permission
     *
     * @param record
     */
    int updateByPrimaryKeySelective(RolePermission record);

    /**
     *  根据主键来更新符合条件的数据库记录,t_role_permission
     *
     * @param record
     */
    int updateByPrimaryKey(RolePermission record);

    int insertBatchSelective(List<RolePermission> records);

    int updateBatchByPrimaryKeySelective(List<RolePermission> records);
}