package com.graduationaldesign.graduation.mapper;

import com.graduationaldesign.graduation.pojo.Admin;
import com.graduationaldesign.graduation.pojo.AdminExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminMapper {
    /**
     *  根据指定的条件获取数据库记录数,t_admin
     *
     * @param example
     */
    long countByExample(AdminExample example);

    /**
     *  根据指定的条件删除数据库符合条件的记录,t_admin
     *
     * @param example
     */
    int deleteByExample(AdminExample example);

    /**
     *  根据主键删除数据库的记录,t_admin
     *
     * @param adminId
     */
    int deleteByPrimaryKey(String adminId);

    /**
     *  新写入数据库记录,t_admin
     *
     * @param record
     */
    int insert(Admin record);

    /**
     *  动态字段,写入数据库记录,t_admin
     *
     * @param record
     */
    int insertSelective(Admin record);

    /**
     *  根据指定的条件查询符合条件的数据库记录,t_admin
     *
     * @param example
     */
    List<Admin> selectByExample(AdminExample example);

    /**
     *  根据指定主键获取一条数据库记录,t_admin
     *
     * @param adminId
     */
    Admin selectByPrimaryKey(String adminId);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,t_admin
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") Admin record, @Param("example") AdminExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,t_admin
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") Admin record, @Param("example") AdminExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,t_admin
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Admin record);

    /**
     *  根据主键来更新符合条件的数据库记录,t_admin
     *
     * @param record
     */
    int updateByPrimaryKey(Admin record);

    int insertBatchSelective(List<Admin> records);

    int updateBatchByPrimaryKeySelective(List<Admin> records);
}