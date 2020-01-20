package com.graduationaldesign.graduation.mapper;

import com.graduationaldesign.graduation.pojo.UserRole;
import com.graduationaldesign.graduation.pojo.UserRoleExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserRoleMapper {
    /**
     *  根据指定的条件获取数据库记录数,user_role
     *
     * @param example
     */
    long countByExample(UserRoleExample example);

    /**
     *  根据指定的条件删除数据库符合条件的记录,user_role
     *
     * @param example
     */
    int deleteByExample(UserRoleExample example);

    /**
     *  根据主键删除数据库的记录,user_role
     *
     * @param id
     */
    int deleteByPrimaryKey(Long id);

    /**
     *  新写入数据库记录,user_role
     *
     * @param record
     */
    int insert(UserRole record);

    /**
     *  动态字段,写入数据库记录,user_role
     *
     * @param record
     */
    int insertSelective(UserRole record);

    /**
     *  根据指定的条件查询符合条件的数据库记录,user_role
     *
     * @param example
     */
    List<UserRole> selectByExample(UserRoleExample example);

    /**
     *  根据指定主键获取一条数据库记录,user_role
     *
     * @param id
     */
    UserRole selectByPrimaryKey(Long id);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,user_role
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") UserRole record, @Param("example") UserRoleExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,user_role
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") UserRole record, @Param("example") UserRoleExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,user_role
     *
     * @param record
     */
    int updateByPrimaryKeySelective(UserRole record);

    /**
     *  根据主键来更新符合条件的数据库记录,user_role
     *
     * @param record
     */
    int updateByPrimaryKey(UserRole record);

    int insertBatchSelective(List<UserRole> records);

    int updateBatchByPrimaryKeySelective(List<UserRole> records);
}