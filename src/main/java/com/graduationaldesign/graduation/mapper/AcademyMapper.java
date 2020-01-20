package com.graduationaldesign.graduation.mapper;

import com.graduationaldesign.graduation.pojo.Academy;
import com.graduationaldesign.graduation.pojo.AcademyExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface AcademyMapper {
    /**
     *  根据指定的条件获取数据库记录数,t_academy
     *
     * @param example
     */
    long countByExample(AcademyExample example);

    /**
     *  根据指定的条件删除数据库符合条件的记录,t_academy
     *
     * @param example
     */
    int deleteByExample(AcademyExample example);

    /**
     *  根据主键删除数据库的记录,t_academy
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,t_academy
     *
     * @param record
     */
    int insert(Academy record);

    /**
     *  动态字段,写入数据库记录,t_academy
     *
     * @param record
     */
    int insertSelective(Academy record);

    /**
     * ,t_academy
     *
     * @param example
     */
    List<Academy> selectByExampleWithBLOBs(AcademyExample example);

    /**
     *  根据指定的条件查询符合条件的数据库记录,t_academy
     *
     * @param example
     */
    List<Academy> selectByExample(AcademyExample example);

    /**
     *  根据指定主键获取一条数据库记录,t_academy
     *
     * @param id
     */
    Academy selectByPrimaryKey(Integer id);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,t_academy
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") Academy record, @Param("example") AcademyExample example);

    /**
     * ,t_academy
     *
     * @param record
     * @param example
     */
    int updateByExampleWithBLOBs(@Param("record") Academy record, @Param("example") AcademyExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,t_academy
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") Academy record, @Param("example") AcademyExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,t_academy
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Academy record);

    /**
     * ,t_academy
     *
     * @param record
     */
    int updateByPrimaryKeyWithBLOBs(Academy record);

    /**
     *  根据主键来更新符合条件的数据库记录,t_academy
     *
     * @param record
     */
    int updateByPrimaryKey(Academy record);

    int insertBatchSelective(List<Academy> records);

    int updateBatchByPrimaryKeySelective(List<Academy> records);
}