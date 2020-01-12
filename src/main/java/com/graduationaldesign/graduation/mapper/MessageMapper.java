package com.graduationaldesign.graduation.mapper;

import com.graduationaldesign.graduation.pojo.Message;
import com.graduationaldesign.graduation.pojo.MessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MessageMapper {
    /**
     *  根据指定的条件获取数据库记录数,message
     *
     * @param example
     */
    long countByExample(MessageExample example);

    /**
     *  根据指定的条件删除数据库符合条件的记录,message
     *
     * @param example
     */
    int deleteByExample(MessageExample example);

    /**
     *  根据主键删除数据库的记录,message
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,message
     *
     * @param record
     */
    int insert(Message record);

    /**
     *  动态字段,写入数据库记录,message
     *
     * @param record
     */
    int insertSelective(Message record);

    /**
     *  根据指定的条件查询符合条件的数据库记录,message
     *
     * @param example
     */
    List<Message> selectByExample(MessageExample example);

    /**
     *  根据指定主键获取一条数据库记录,message
     *
     * @param id
     */
    Message selectByPrimaryKey(Integer id);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,message
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") Message record, @Param("example") MessageExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,message
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") Message record, @Param("example") MessageExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,message
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Message record);

    /**
     *  根据主键来更新符合条件的数据库记录,message
     *
     * @param record
     */
    int updateByPrimaryKey(Message record);

    int insertBatchSelective(List<Message> records);

    int updateBatchByPrimaryKeySelective(List<Message> records);
}