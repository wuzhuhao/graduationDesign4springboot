package com.graduationaldesign.graduation.mapper;

import com.graduationaldesign.graduation.pojo.Teacher;
import com.graduationaldesign.graduation.pojo.TeacherExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface TeacherMapper {
    /**
     *  根据指定的条件获取数据库记录数,t_teacher
     *
     * @param example
     */
    long countByExample(TeacherExample example);

    /**
     *  根据指定的条件删除数据库符合条件的记录,t_teacher
     *
     * @param example
     */
    int deleteByExample(TeacherExample example);

    /**
     *  根据主键删除数据库的记录,t_teacher
     *
     * @param teaId
     */
    int deleteByPrimaryKey(String teaId);

    /**
     *  新写入数据库记录,t_teacher
     *
     * @param record
     */
    int insert(Teacher record);

    /**
     *  动态字段,写入数据库记录,t_teacher
     *
     * @param record
     */
    int insertSelective(Teacher record);

    /**
     *  根据指定的条件查询符合条件的数据库记录,t_teacher
     *
     * @param example
     */
    List<Teacher> selectByExample(TeacherExample example);

    /**
     *  根据指定主键获取一条数据库记录,t_teacher
     *
     * @param teaId
     */
    Teacher selectByPrimaryKey(String teaId);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,t_teacher
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") Teacher record, @Param("example") TeacherExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,t_teacher
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") Teacher record, @Param("example") TeacherExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,t_teacher
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Teacher record);

    /**
     *  根据主键来更新符合条件的数据库记录,t_teacher
     *
     * @param record
     */
    int updateByPrimaryKey(Teacher record);

    int insertBatchSelective(List<Teacher> records);

    int updateBatchByPrimaryKeySelective(List<Teacher> records);
}