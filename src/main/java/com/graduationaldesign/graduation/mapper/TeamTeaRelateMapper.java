package com.graduationaldesign.graduation.mapper;

import com.graduationaldesign.graduation.pojo.TeamTeaRelate;
import com.graduationaldesign.graduation.pojo.TeamTeaRelateExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TeamTeaRelateMapper {
    /**
     * 根据指定的条件获取数据库记录数,team_tea_relate
     *
     * @param example
     */
    long countByExample(TeamTeaRelateExample example);

    /**
     * 根据指定的条件删除数据库符合条件的记录,team_tea_relate
     *
     * @param example
     */
    int deleteByExample(TeamTeaRelateExample example);

    /**
     * 根据主键删除数据库的记录,team_tea_relate
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新写入数据库记录,team_tea_relate
     *
     * @param record
     */
    int insert(TeamTeaRelate record);

    /**
     * 动态字段,写入数据库记录,team_tea_relate
     *
     * @param record
     */
    int insertSelective(TeamTeaRelate record);

    /**
     * 根据指定的条件查询符合条件的数据库记录,team_tea_relate
     *
     * @param example
     */
    List<TeamTeaRelate> selectByExample(TeamTeaRelateExample example);

    /**
     * 根据指定主键获取一条数据库记录,team_tea_relate
     *
     * @param id
     */
    TeamTeaRelate selectByPrimaryKey(Integer id);

    /**
     * 动态根据指定的条件来更新符合条件的数据库记录,team_tea_relate
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") TeamTeaRelate record, @Param("example") TeamTeaRelateExample example);

    /**
     * 根据指定的条件来更新符合条件的数据库记录,team_tea_relate
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") TeamTeaRelate record, @Param("example") TeamTeaRelateExample example);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录,team_tea_relate
     *
     * @param record
     */
    int updateByPrimaryKeySelective(TeamTeaRelate record);

    /**
     * 根据主键来更新符合条件的数据库记录,team_tea_relate
     *
     * @param record
     */
    int updateByPrimaryKey(TeamTeaRelate record);

    int insertBatchSelective(List<TeamTeaRelate> records);

    int updateBatchByPrimaryKeySelective(List<TeamTeaRelate> records);
}