package com.graduationaldesign.graduation.mapper;

import com.graduationaldesign.graduation.pojo.Progress;
import com.graduationaldesign.graduation.pojo.ProgressExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProgressMapper {
    /**
     *  根据指定的条件获取数据库记录数,t_progress
     *
     * @param example
     */
    long countByExample(ProgressExample example);

    /**
     *  根据指定的条件删除数据库符合条件的记录,t_progress
     *
     * @param example
     */
    int deleteByExample(ProgressExample example);

    /**
     *  根据主键删除数据库的记录,t_progress
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,t_progress
     *
     * @param record
     */
    int insert(Progress record);

    /**
     *  动态字段,写入数据库记录,t_progress
     *
     * @param record
     */
    int insertSelective(Progress record);

    /**
     * ,t_progress
     *
     * @param example
     */
    List<Progress> selectByExampleWithBLOBs(ProgressExample example);

    /**
     *  根据指定的条件查询符合条件的数据库记录,t_progress
     *
     * @param example
     */
    List<Progress> selectByExample(ProgressExample example);

    /**
     *  根据指定主键获取一条数据库记录,t_progress
     *
     * @param id
     */
    Progress selectByPrimaryKey(Integer id);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,t_progress
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") Progress record, @Param("example") ProgressExample example);

    /**
     * ,t_progress
     *
     * @param record
     * @param example
     */
    int updateByExampleWithBLOBs(@Param("record") Progress record, @Param("example") ProgressExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,t_progress
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") Progress record, @Param("example") ProgressExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,t_progress
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Progress record);

    /**
     * ,t_progress
     *
     * @param record
     */
    int updateByPrimaryKeyWithBLOBs(Progress record);

    /**
     *  根据主键来更新符合条件的数据库记录,t_progress
     *
     * @param record
     */
    int updateByPrimaryKey(Progress record);

    int insertBatchSelective(List<Progress> records);

    int updateBatchByPrimaryKeySelective(List<Progress> records);
}