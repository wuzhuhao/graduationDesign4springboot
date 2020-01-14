package com.graduationaldesign.graduation.mapper;

import com.graduationaldesign.graduation.pojo.Student;
import com.graduationaldesign.graduation.pojo.StudentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {
    /**
     *  根据指定的条件获取数据库记录数,t_student
     *
     * @param example
     */
    long countByExample(StudentExample example);

    /**
     *  根据指定的条件删除数据库符合条件的记录,t_student
     *
     * @param example
     */
    int deleteByExample(StudentExample example);

    /**
     *  根据主键删除数据库的记录,t_student
     *
     * @param stuId
     */
    int deleteByPrimaryKey(String stuId);

    /**
     *  新写入数据库记录,t_student
     *
     * @param record
     */
    int insert(Student record);

    /**
     *  动态字段,写入数据库记录,t_student
     *
     * @param record
     */
    int insertSelective(Student record);

    /**
     *  根据指定的条件查询符合条件的数据库记录,t_student
     *
     * @param example
     */
    List<Student> selectByExample(StudentExample example);

    /**
     *  根据指定主键获取一条数据库记录,t_student
     *
     * @param stuId
     */
    Student selectByPrimaryKey(String stuId);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,t_student
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") Student record, @Param("example") StudentExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,t_student
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") Student record, @Param("example") StudentExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,t_student
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Student record);

    /**
     *  根据主键来更新符合条件的数据库记录,t_student
     *
     * @param record
     */
    int updateByPrimaryKey(Student record);

    int insertBatchSelective(List<Student> records);

    int updateBatchByPrimaryKeySelective(List<Student> records);
}