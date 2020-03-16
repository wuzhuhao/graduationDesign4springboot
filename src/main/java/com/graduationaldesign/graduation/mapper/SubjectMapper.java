package com.graduationaldesign.graduation.mapper;

import com.graduationaldesign.graduation.pojo.Subject;
import com.graduationaldesign.graduation.pojo.SubjectExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface SubjectMapper {

    int PAGE_SIZE = 5;

    /**
     * 根据指定的条件获取数据库记录数,t_subject
     *
     * @param example
     */
    long countByExample(SubjectExample example);

    /**
     * 根据指定的条件删除数据库符合条件的记录,t_subject
     *
     * @param example
     */
    int deleteByExample(SubjectExample example);

    /**
     * 根据主键删除数据库的记录,t_subject
     *
     * @param subId
     */
    int deleteByPrimaryKey(String subId);

    /**
     * 新写入数据库记录,t_subject
     *
     * @param record
     */
    int insert(Subject record);

    /**
     * 动态字段,写入数据库记录,t_subject
     *
     * @param record
     */
    int insertSelective(Subject record);

    /**
     * ,t_subject
     *
     * @param example
     */
    List<Subject> selectByExampleWithBLOBs(SubjectExample example);

    /**
     * 根据指定的条件查询符合条件的数据库记录,t_subject
     *
     * @param example
     */
    List<Subject> selectByExample(SubjectExample example);

    /**
     * 根据指定主键获取一条数据库记录,t_subject
     *
     * @param subId
     */
    Subject selectByPrimaryKey(String subId);

    /**
     * 动态根据指定的条件来更新符合条件的数据库记录,t_subject
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") Subject record,
                                 @Param("example") SubjectExample example);

    /**
     * ,t_subject
     *
     * @param record
     * @param example
     */
    int updateByExampleWithBLOBs(@Param("record") Subject record,
                                 @Param("example") SubjectExample example);

    /**
     * 根据指定的条件来更新符合条件的数据库记录,t_subject
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") Subject record, @Param("example") SubjectExample example);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录,t_subject
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Subject record);

    /**
     * ,t_subject
     *
     * @param record
     */
    int updateByPrimaryKeyWithBLOBs(Subject record);

    /**
     * 根据主键来更新符合条件的数据库记录,t_subject
     *
     * @param record
     */
    int updateByPrimaryKey(Subject record);

    int insertBatchSelective(List<Subject> records);

    int updateBatchByPrimaryKeySelective(List<Subject> records);

    List<Map<String, Object>> selectByExampleWithMap(SubjectExample example);
}