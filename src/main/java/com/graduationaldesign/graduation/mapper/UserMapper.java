package com.graduationaldesign.graduation.mapper;

import com.graduationaldesign.graduation.pojo.User;
import com.graduationaldesign.graduation.pojo.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    /**
     *  根据指定的条件获取数据库记录数,user
     *
     * @param example
     */
    long countByExample(UserExample example);

    /**
     *  根据指定的条件删除数据库符合条件的记录,user
     *
     * @param example
     */
    int deleteByExample(UserExample example);

    /**
     *  根据主键删除数据库的记录,user
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,user
     *
     * @param record
     */
    int insert(User record);

    /**
     *  动态字段,写入数据库记录,user
     *
     * @param record
     */
    int insertSelective(User record);

    /**
     *  根据指定的条件查询符合条件的数据库记录,user
     *
     * @param example
     */
    List<User> selectByExample(UserExample example);

    /**
     *  根据指定主键获取一条数据库记录,user
     *
     * @param id
     */
    User selectByPrimaryKey(Integer id);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,user
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,user
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,user
     *
     * @param record
     */
    int updateByPrimaryKeySelective(User record);

    /**
     *  根据主键来更新符合条件的数据库记录,user
     *
     * @param record
     */
    int updateByPrimaryKey(User record);

    int insertBatchSelective(List<User> records);

    int updateBatchByPrimaryKeySelective(List<User> records);
}