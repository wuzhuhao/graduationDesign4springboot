package com.graduationaldesign.graduation.mapper;

import com.graduationaldesign.graduation.pojo.Like;
import com.graduationaldesign.graduation.pojo.LikeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LikeMapper {
    /**
     *  根据指定的条件获取数据库记录数,like_diary
     *
     * @param example
     */
    long countByExample(LikeExample example);

    /**
     *  根据指定的条件删除数据库符合条件的记录,like_diary
     *
     * @param example
     */
    int deleteByExample(LikeExample example);

    /**
     *  根据主键删除数据库的记录,like_diary
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,like_diary
     *
     * @param record
     */
    int insert(Like record);

    /**
     *  动态字段,写入数据库记录,like_diary
     *
     * @param record
     */
    int insertSelective(Like record);

    /**
     *  根据指定的条件查询符合条件的数据库记录,like_diary
     *
     * @param example
     */
    List<Like> selectByExample(LikeExample example);

    /**
     *  根据指定主键获取一条数据库记录,like_diary
     *
     * @param id
     */
    Like selectByPrimaryKey(Integer id);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,like_diary
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") Like record, @Param("example") LikeExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,like_diary
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") Like record, @Param("example") LikeExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,like_diary
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Like record);

    /**
     *  根据主键来更新符合条件的数据库记录,like_diary
     *
     * @param record
     */
    int updateByPrimaryKey(Like record);

    int insertBatchSelective(List<Like> records);

    int updateBatchByPrimaryKeySelective(List<Like> records);
}