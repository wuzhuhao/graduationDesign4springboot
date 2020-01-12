package com.graduationaldesign.graduation.mapper;

import com.graduationaldesign.graduation.pojo.DiaryPhoto;
import com.graduationaldesign.graduation.pojo.DiaryPhotoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DiaryPhotoMapper {
    /**
     *  根据指定的条件获取数据库记录数,diaryphoto
     *
     * @param example
     */
    long countByExample(DiaryPhotoExample example);

    /**
     *  根据指定的条件删除数据库符合条件的记录,diaryphoto
     *
     * @param example
     */
    int deleteByExample(DiaryPhotoExample example);

    /**
     *  根据主键删除数据库的记录,diaryphoto
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,diaryphoto
     *
     * @param record
     */
    int insert(DiaryPhoto record);

    /**
     *  动态字段,写入数据库记录,diaryphoto
     *
     * @param record
     */
    int insertSelective(DiaryPhoto record);

    /**
     *  根据指定的条件查询符合条件的数据库记录,diaryphoto
     *
     * @param example
     */
    List<DiaryPhoto> selectByExample(DiaryPhotoExample example);

    /**
     *  根据指定主键获取一条数据库记录,diaryphoto
     *
     * @param id
     */
    DiaryPhoto selectByPrimaryKey(Integer id);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,diaryphoto
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") DiaryPhoto record, @Param("example") DiaryPhotoExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,diaryphoto
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") DiaryPhoto record, @Param("example") DiaryPhotoExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,diaryphoto
     *
     * @param record
     */
    int updateByPrimaryKeySelective(DiaryPhoto record);

    /**
     *  根据主键来更新符合条件的数据库记录,diaryphoto
     *
     * @param record
     */
    int updateByPrimaryKey(DiaryPhoto record);

    int insertBatchSelective(List<DiaryPhoto> records);

    int updateBatchByPrimaryKeySelective(List<DiaryPhoto> records);
}