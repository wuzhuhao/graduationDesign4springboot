package com.graduationaldesign.graduation.mapper;

import com.graduationaldesign.graduation.pojo.Diary;
import com.graduationaldesign.graduation.pojo.DiaryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DiaryMapper {
    int PAGE_SIZE=5;
    /**
     *  根据指定的条件获取数据库记录数,diary
     *
     * @param example
     */
    long countByExample(DiaryExample example);

    /**
     *  根据指定的条件删除数据库符合条件的记录,diary
     *
     * @param example
     */
    int deleteByExample(DiaryExample example);

    /**
     *  根据主键删除数据库的记录,diary
     *
     * @param did
     */
    int deleteByPrimaryKey(Integer did);

    /**
     *  新写入数据库记录,diary
     *
     * @param record
     */
    int insert(Diary record);

    /**
     *  动态字段,写入数据库记录,diary
     *
     * @param record
     */
    int insertSelective(Diary record);

    /**
     * ,diary
     *
     * @param example
     */
    List<Diary> selectByExampleWithBLOBs(DiaryExample example);

    /**
     *  根据指定的条件查询符合条件的数据库记录,diary
     *
     * @param example
     */
    List<Diary> selectByExample(DiaryExample example);

    /**
     *  根据指定主键获取一条数据库记录,diary
     *
     * @param did
     */
    Diary selectByPrimaryKey(Integer did);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,diary
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") Diary record, @Param("example") DiaryExample example);

    /**
     * ,diary
     *
     * @param record
     * @param example
     */
    int updateByExampleWithBLOBs(@Param("record") Diary record, @Param("example") DiaryExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,diary
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") Diary record, @Param("example") DiaryExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,diary
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Diary record);

    /**
     * ,diary
     *
     * @param record
     */
    int updateByPrimaryKeyWithBLOBs(Diary record);

    /**
     *  根据主键来更新符合条件的数据库记录,diary
     *
     * @param record
     */
    int updateByPrimaryKey(Diary record);

    int insertBatchSelective(List<Diary> records);

    int updateBatchByPrimaryKeySelective(List<Diary> records);
}