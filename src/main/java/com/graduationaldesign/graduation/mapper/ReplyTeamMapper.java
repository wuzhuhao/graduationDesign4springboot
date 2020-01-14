package com.graduationaldesign.graduation.mapper;

import com.graduationaldesign.graduation.pojo.ReplyTeam;
import com.graduationaldesign.graduation.pojo.ReplyTeamExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReplyTeamMapper {
    /**
     *  根据指定的条件获取数据库记录数,reply_team
     *
     * @param example
     */
    long countByExample(ReplyTeamExample example);

    /**
     *  根据指定的条件删除数据库符合条件的记录,reply_team
     *
     * @param example
     */
    int deleteByExample(ReplyTeamExample example);

    /**
     *  根据主键删除数据库的记录,reply_team
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,reply_team
     *
     * @param record
     */
    int insert(ReplyTeam record);

    /**
     *  动态字段,写入数据库记录,reply_team
     *
     * @param record
     */
    int insertSelective(ReplyTeam record);

    /**
     *  根据指定的条件查询符合条件的数据库记录,reply_team
     *
     * @param example
     */
    List<ReplyTeam> selectByExample(ReplyTeamExample example);

    /**
     *  根据指定主键获取一条数据库记录,reply_team
     *
     * @param id
     */
    ReplyTeam selectByPrimaryKey(Integer id);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,reply_team
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") ReplyTeam record, @Param("example") ReplyTeamExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,reply_team
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") ReplyTeam record, @Param("example") ReplyTeamExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,reply_team
     *
     * @param record
     */
    int updateByPrimaryKeySelective(ReplyTeam record);

    /**
     *  根据主键来更新符合条件的数据库记录,reply_team
     *
     * @param record
     */
    int updateByPrimaryKey(ReplyTeam record);

    int insertBatchSelective(List<ReplyTeam> records);

    int updateBatchByPrimaryKeySelective(List<ReplyTeam> records);
}