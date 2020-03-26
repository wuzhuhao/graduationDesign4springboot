package com.graduationaldesign.graduation.mapper;

import com.graduationaldesign.graduation.pojo.Sysdict;
import com.graduationaldesign.graduation.pojo.SysdictExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysdictMapper {
    /**
     * 根据指定的条件获取数据库记录数,sys_sysdict
     *
     * @param example
     */
    long countByExample(SysdictExample example);

    /**
     * 根据指定的条件删除数据库符合条件的记录,sys_sysdict
     *
     * @param example
     */
    int deleteByExample(SysdictExample example);

    /**
     * 根据主键删除数据库的记录,sys_sysdict
     *
     * @param id
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 新写入数据库记录,sys_sysdict
     *
     * @param record
     */
    int insert(Sysdict record);

    /**
     * 动态字段,写入数据库记录,sys_sysdict
     *
     * @param record
     */
    int insertSelective(Sysdict record);

    /**
     * 根据指定的条件查询符合条件的数据库记录,sys_sysdict
     *
     * @param example
     */
    List<Sysdict> selectByExample(SysdictExample example);

    /**
     * 根据指定主键获取一条数据库记录,sys_sysdict
     *
     * @param id
     */
    Sysdict selectByPrimaryKey(Long id);

    /**
     * 动态根据指定的条件来更新符合条件的数据库记录,sys_sysdict
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") Sysdict record, @Param("example") SysdictExample example);

    /**
     * 根据指定的条件来更新符合条件的数据库记录,sys_sysdict
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") Sysdict record, @Param("example") SysdictExample example);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录,sys_sysdict
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Sysdict record);

    /**
     * 根据主键来更新符合条件的数据库记录,sys_sysdict
     *
     * @param record
     */
    int updateByPrimaryKey(Sysdict record);

    int insertBatchSelective(List<Sysdict> records);

    int updateBatchByPrimaryKeySelective(List<Sysdict> records);
}