package com.graduationaldesign.graduation.mapper;

import com.graduationaldesign.graduation.pojo.Permission;
import com.graduationaldesign.graduation.pojo.PermissionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionMapper {
    /**
     *  根据指定的条件获取数据库记录数,t_permission
     *
     * @param example
     */
    long countByExample(PermissionExample example);

    /**
     *  根据指定的条件删除数据库符合条件的记录,t_permission
     *
     * @param example
     */
    int deleteByExample(PermissionExample example);

    /**
     *  根据主键删除数据库的记录,t_permission
     *
     * @param id
     */
    int deleteByPrimaryKey(Long id);

    /**
     *  新写入数据库记录,t_permission
     *
     * @param record
     */
    int insert(Permission record);

    /**
     *  动态字段,写入数据库记录,t_permission
     *
     * @param record
     */
    int insertSelective(Permission record);

    /**
     *  根据指定的条件查询符合条件的数据库记录,t_permission
     *
     * @param example
     */
    List<Permission> selectByExample(PermissionExample example);

    /**
     *  根据指定主键获取一条数据库记录,t_permission
     *
     * @param id
     */
    Permission selectByPrimaryKey(Long id);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,t_permission
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,t_permission
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") Permission record, @Param("example") PermissionExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,t_permission
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Permission record);

    /**
     *  根据主键来更新符合条件的数据库记录,t_permission
     *
     * @param record
     */
    int updateByPrimaryKey(Permission record);

    int insertBatchSelective(List<Permission> records);

    int updateBatchByPrimaryKeySelective(List<Permission> records);
}