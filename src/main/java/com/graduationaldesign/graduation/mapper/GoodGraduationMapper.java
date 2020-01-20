package com.graduationaldesign.graduation.mapper;

import com.graduationaldesign.graduation.pojo.GoodGraduation;
import com.graduationaldesign.graduation.pojo.GoodGraduationExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface GoodGraduationMapper {
    /**
     *  根据指定的条件获取数据库记录数,t_goodgraduation
     *
     * @param example
     */
    long countByExample(GoodGraduationExample example);

    /**
     *  根据指定的条件删除数据库符合条件的记录,t_goodgraduation
     *
     * @param example
     */
    int deleteByExample(GoodGraduationExample example);

    /**
     *  根据主键删除数据库的记录,t_goodgraduation
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,t_goodgraduation
     *
     * @param record
     */
    int insert(GoodGraduation record);

    /**
     *  动态字段,写入数据库记录,t_goodgraduation
     *
     * @param record
     */
    int insertSelective(GoodGraduation record);

    /**
     * ,t_goodgraduation
     *
     * @param example
     */
    List<GoodGraduation> selectByExampleWithBLOBs(GoodGraduationExample example);

    /**
     *  根据指定的条件查询符合条件的数据库记录,t_goodgraduation
     *
     * @param example
     */
    List<GoodGraduation> selectByExample(GoodGraduationExample example);

    /**
     *  根据指定主键获取一条数据库记录,t_goodgraduation
     *
     * @param id
     */
    GoodGraduation selectByPrimaryKey(Integer id);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,t_goodgraduation
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") GoodGraduation record, @Param("example") GoodGraduationExample example);

    /**
     * ,t_goodgraduation
     *
     * @param record
     * @param example
     */
    int updateByExampleWithBLOBs(@Param("record") GoodGraduation record, @Param("example") GoodGraduationExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,t_goodgraduation
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") GoodGraduation record, @Param("example") GoodGraduationExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,t_goodgraduation
     *
     * @param record
     */
    int updateByPrimaryKeySelective(GoodGraduation record);

    /**
     * ,t_goodgraduation
     *
     * @param record
     */
    int updateByPrimaryKeyWithBLOBs(GoodGraduation record);

    /**
     *  根据主键来更新符合条件的数据库记录,t_goodgraduation
     *
     * @param record
     */
    int updateByPrimaryKey(GoodGraduation record);

    int insertBatchSelective(List<GoodGraduation> records);

    int updateBatchByPrimaryKeySelective(List<GoodGraduation> records);
}