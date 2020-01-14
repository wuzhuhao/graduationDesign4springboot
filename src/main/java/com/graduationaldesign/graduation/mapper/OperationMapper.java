package com.graduationaldesign.graduation.mapper;

import com.graduationaldesign.graduation.pojo.Operation;
import com.graduationaldesign.graduation.pojo.OperationExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OperationMapper {
    /**
     *  根据指定的条件获取数据库记录数,log_operation
     *
     * @param example
     */
    long countByExample(OperationExample example);

    /**
     *  根据指定的条件删除数据库符合条件的记录,log_operation
     *
     * @param example
     */
    int deleteByExample(OperationExample example);

    /**
     *  根据主键删除数据库的记录,log_operation
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,log_operation
     *
     * @param record
     */
    int insert(Operation record);

    /**
     *  动态字段,写入数据库记录,log_operation
     *
     * @param record
     */
    int insertSelective(Operation record);

    /**
     * ,log_operation
     *
     * @param example
     */
    List<Operation> selectByExampleWithBLOBs(OperationExample example);

    /**
     *  根据指定的条件查询符合条件的数据库记录,log_operation
     *
     * @param example
     */
    List<Operation> selectByExample(OperationExample example);

    /**
     *  根据指定主键获取一条数据库记录,log_operation
     *
     * @param id
     */
    Operation selectByPrimaryKey(Integer id);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,log_operation
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") Operation record, @Param("example") OperationExample example);

    /**
     * ,log_operation
     *
     * @param record
     * @param example
     */
    int updateByExampleWithBLOBs(@Param("record") Operation record, @Param("example") OperationExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,log_operation
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") Operation record, @Param("example") OperationExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,log_operation
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Operation record);

    /**
     * ,log_operation
     *
     * @param record
     */
    int updateByPrimaryKeyWithBLOBs(Operation record);

    /**
     *  根据主键来更新符合条件的数据库记录,log_operation
     *
     * @param record
     */
    int updateByPrimaryKey(Operation record);

    int insertBatchSelective(List<Operation> records);

    int updateBatchByPrimaryKeySelective(List<Operation> records);
}