package com.graduationaldesign.graduation.mapper;

import com.graduationaldesign.graduation.pojo.ScoreRecord;
import com.graduationaldesign.graduation.pojo.ScoreRecordExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ScoreRecordMapper extends Mapper<ScoreRecord, ScoreRecordExample> {
    /**
     * 根据指定的条件获取数据库记录数,t_scorerecord
     *
     * @param example
     */
    long countByExample(ScoreRecordExample example);

    /**
     * 根据指定的条件删除数据库符合条件的记录,t_scorerecord
     *
     * @param example
     */
    int deleteByExample(ScoreRecordExample example);

    /**
     * 根据主键删除数据库的记录,t_scorerecord
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * 新写入数据库记录,t_scorerecord
     *
     * @param record
     */
    int insert(ScoreRecord record);

    /**
     * 动态字段,写入数据库记录,t_scorerecord
     *
     * @param record
     */
    int insertSelective(ScoreRecord record);

    /**
     * 根据指定的条件查询符合条件的数据库记录,t_scorerecord
     *
     * @param example
     */
    List<ScoreRecord> selectByExample(ScoreRecordExample example);

    /**
     * 根据指定主键获取一条数据库记录,t_scorerecord
     *
     * @param id
     */
    ScoreRecord selectByPrimaryKey(Integer id);

    /**
     * 动态根据指定的条件来更新符合条件的数据库记录,t_scorerecord
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") ScoreRecord record, @Param("example") ScoreRecordExample example);

    /**
     * 根据指定的条件来更新符合条件的数据库记录,t_scorerecord
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") ScoreRecord record, @Param("example") ScoreRecordExample example);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录,t_scorerecord
     *
     * @param record
     */
    int updateByPrimaryKeySelective(ScoreRecord record);

    /**
     * 根据主键来更新符合条件的数据库记录,t_scorerecord
     *
     * @param record
     */
    int updateByPrimaryKey(ScoreRecord record);

    @Override
    int insertBatchSelective(List<ScoreRecord> records);

    int updateBatchByPrimaryKeySelective(List<ScoreRecord> records);
}