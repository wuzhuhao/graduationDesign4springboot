package com.graduationaldesign.graduation.mapper;

import com.graduationaldesign.graduation.pojo.Task;
import com.graduationaldesign.graduation.pojo.TaskExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface TaskMapper {
    /**
     *  根据指定的条件获取数据库记录数,t_task
     *
     * @param example
     */
    long countByExample(TaskExample example);

    /**
     *  根据指定的条件删除数据库符合条件的记录,t_task
     *
     * @param example
     */
    int deleteByExample(TaskExample example);

    /**
     *  根据主键删除数据库的记录,t_task
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,t_task
     *
     * @param record
     */
    int insert(Task record);

    /**
     *  动态字段,写入数据库记录,t_task
     *
     * @param record
     */
    int insertSelective(Task record);

    /**
     * ,t_task
     *
     * @param example
     */
    List<Task> selectByExampleWithBLOBs(TaskExample example);

    /**
     *  根据指定的条件查询符合条件的数据库记录,t_task
     *
     * @param example
     */
    List<Task> selectByExample(TaskExample example);

    /**
     *  根据指定主键获取一条数据库记录,t_task
     *
     * @param id
     */
    Task selectByPrimaryKey(Integer id);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,t_task
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") Task record, @Param("example") TaskExample example);

    /**
     * ,t_task
     *
     * @param record
     * @param example
     */
    int updateByExampleWithBLOBs(@Param("record") Task record, @Param("example") TaskExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,t_task
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") Task record, @Param("example") TaskExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,t_task
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Task record);

    /**
     * ,t_task
     *
     * @param record
     */
    int updateByPrimaryKeyWithBLOBs(Task record);

    /**
     *  根据主键来更新符合条件的数据库记录,t_task
     *
     * @param record
     */
    int updateByPrimaryKey(Task record);

    int insertBatchSelective(List<Task> records);

    int updateBatchByPrimaryKeySelective(List<Task> records);
}