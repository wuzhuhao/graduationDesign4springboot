package com.graduationaldesign.graduation.mapper;

import com.graduationaldesign.graduation.pojo.Usermessage;
import com.graduationaldesign.graduation.pojo.UsermessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsermessageMapper {
    /**
     *  根据指定的条件获取数据库记录数,usermessage
     *
     * @param example
     */
    long countByExample(UsermessageExample example);

    /**
     *  根据指定的条件删除数据库符合条件的记录,usermessage
     *
     * @param example
     */
    int deleteByExample(UsermessageExample example);

    /**
     *  根据主键删除数据库的记录,usermessage
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,usermessage
     *
     * @param record
     */
    int insert(Usermessage record);

    /**
     *  动态字段,写入数据库记录,usermessage
     *
     * @param record
     */
    int insertSelective(Usermessage record);

    /**
     *  根据指定的条件查询符合条件的数据库记录,usermessage
     *
     * @param example
     */
    List<Usermessage> selectByExample(UsermessageExample example);

    /**
     *  根据指定主键获取一条数据库记录,usermessage
     *
     * @param id
     */
    Usermessage selectByPrimaryKey(Integer id);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,usermessage
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") Usermessage record, @Param("example") UsermessageExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,usermessage
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") Usermessage record, @Param("example") UsermessageExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,usermessage
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Usermessage record);

    /**
     *  根据主键来更新符合条件的数据库记录,usermessage
     *
     * @param record
     */
    int updateByPrimaryKey(Usermessage record);

    int insertBatchSelective(List<Usermessage> records);

    int updateBatchByPrimaryKeySelective(List<Usermessage> records);
}