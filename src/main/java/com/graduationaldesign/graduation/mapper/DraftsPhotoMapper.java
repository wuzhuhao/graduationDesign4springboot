package com.graduationaldesign.graduation.mapper;

import com.graduationaldesign.graduation.pojo.DraftsPhoto;
import com.graduationaldesign.graduation.pojo.DraftsPhotoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DraftsPhotoMapper {
    /**
     *  根据指定的条件获取数据库记录数,dphoto
     *
     * @param example
     */
    long countByExample(DraftsPhotoExample example);

    /**
     *  根据指定的条件删除数据库符合条件的记录,dphoto
     *
     * @param example
     */
    int deleteByExample(DraftsPhotoExample example);

    /**
     *  根据主键删除数据库的记录,dphoto
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,dphoto
     *
     * @param record
     */
    int insert(DraftsPhoto record);

    /**
     *  动态字段,写入数据库记录,dphoto
     *
     * @param record
     */
    int insertSelective(DraftsPhoto record);

    /**
     *  根据指定的条件查询符合条件的数据库记录,dphoto
     *
     * @param example
     */
    List<DraftsPhoto> selectByExample(DraftsPhotoExample example);

    /**
     *  根据指定主键获取一条数据库记录,dphoto
     *
     * @param id
     */
    DraftsPhoto selectByPrimaryKey(Integer id);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,dphoto
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") DraftsPhoto record, @Param("example") DraftsPhotoExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,dphoto
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") DraftsPhoto record, @Param("example") DraftsPhotoExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,dphoto
     *
     * @param record
     */
    int updateByPrimaryKeySelective(DraftsPhoto record);

    /**
     *  根据主键来更新符合条件的数据库记录,dphoto
     *
     * @param record
     */
    int updateByPrimaryKey(DraftsPhoto record);

    int insertBatchSelective(List<DraftsPhoto> records);

    int updateBatchByPrimaryKeySelective(List<DraftsPhoto> records);
}