package com.graduationaldesign.graduation.mapper;

import com.graduationaldesign.graduation.pojo.Drafts;
import com.graduationaldesign.graduation.pojo.DraftsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DraftsMapper {
    /**
     *  根据指定的条件获取数据库记录数,ddiary
     *
     * @param example
     */
    long countByExample(DraftsExample example);

    /**
     *  根据指定的条件删除数据库符合条件的记录,ddiary
     *
     * @param example
     */
    int deleteByExample(DraftsExample example);

    /**
     *  根据主键删除数据库的记录,ddiary
     *
     * @param did
     */
    int deleteByPrimaryKey(Integer did);

    /**
     *  新写入数据库记录,ddiary
     *
     * @param record
     */
    int insert(Drafts record);

    /**
     *  动态字段,写入数据库记录,ddiary
     *
     * @param record
     */
    int insertSelective(Drafts record);

    /**
     * ,ddiary
     *
     * @param example
     */
    List<Drafts> selectByExampleWithBLOBs(DraftsExample example);

    /**
     *  根据指定的条件查询符合条件的数据库记录,ddiary
     *
     * @param example
     */
    List<Drafts> selectByExample(DraftsExample example);

    /**
     *  根据指定主键获取一条数据库记录,ddiary
     *
     * @param did
     */
    Drafts selectByPrimaryKey(Integer did);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,ddiary
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") Drafts record, @Param("example") DraftsExample example);

    /**
     * ,ddiary
     *
     * @param record
     * @param example
     */
    int updateByExampleWithBLOBs(@Param("record") Drafts record, @Param("example") DraftsExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,ddiary
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") Drafts record, @Param("example") DraftsExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,ddiary
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Drafts record);

    /**
     * ,ddiary
     *
     * @param record
     */
    int updateByPrimaryKeyWithBLOBs(Drafts record);

    /**
     *  根据主键来更新符合条件的数据库记录,ddiary
     *
     * @param record
     */
    int updateByPrimaryKey(Drafts record);

    int insertBatchSelective(List<Drafts> records);

    int updateBatchByPrimaryKeySelective(List<Drafts> records);
}