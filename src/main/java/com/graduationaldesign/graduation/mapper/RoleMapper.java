package com.graduationaldesign.graduation.mapper;

import com.graduationaldesign.graduation.pojo.Role;
import com.graduationaldesign.graduation.pojo.RoleExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleMapper {
    /**
     *  根据指定的条件获取数据库记录数,t_role
     *
     * @param example
     */
    long countByExample(RoleExample example);

    /**
     *  根据指定的条件删除数据库符合条件的记录,t_role
     *
     * @param example
     */
    int deleteByExample(RoleExample example);

    /**
     *  根据主键删除数据库的记录,t_role
     *
     * @param id
     */
    int deleteByPrimaryKey(Long id);

    /**
     *  新写入数据库记录,t_role
     *
     * @param record
     */
    int insert(Role record);

    /**
     *  动态字段,写入数据库记录,t_role
     *
     * @param record
     */
    int insertSelective(Role record);

    /**
     *  根据指定的条件查询符合条件的数据库记录,t_role
     *
     * @param example
     */
    List<Role> selectByExample(RoleExample example);

    /**
     *  根据指定主键获取一条数据库记录,t_role
     *
     * @param id
     */
    Role selectByPrimaryKey(Long id);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,t_role
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,t_role
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") Role record, @Param("example") RoleExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,t_role
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     *  根据主键来更新符合条件的数据库记录,t_role
     *
     * @param record
     */
    int updateByPrimaryKey(Role record);

    int insertBatchSelective(List<Role> records);

    int updateBatchByPrimaryKeySelective(List<Role> records);
}