package com.graduationaldesign.graduation.mapper;

import com.graduationaldesign.graduation.pojo.Report;
import com.graduationaldesign.graduation.pojo.ReportExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ReportMapper {
    /**
     * 根据指定的条件获取数据库记录数,t_report
     *
     * @param example
     */
    long countByExample(ReportExample example);

    /**
     * 根据指定的条件删除数据库符合条件的记录,t_report
     *
     * @param example
     */
    int deleteByExample(ReportExample example);

    /**
     * 根据主键删除数据库的记录,t_report
     *
     * @param subId
     * @param reportType
     */
    int deleteByPrimaryKey(@Param("reportSubId") String subId, @Param("reportType") Integer reportType);

    /**
     * 新写入数据库记录,t_report
     *
     * @param record
     */
    int insert(Report record);

    /**
     * 动态字段,写入数据库记录,t_report
     *
     * @param record
     */
    int insertSelective(Report record);

    /**
     * ,t_report
     *
     * @param example
     */
    List<Report> selectByExampleWithBLOBs(ReportExample example);

    /**
     * 根据指定的条件查询符合条件的数据库记录,t_report
     *
     * @param example
     */
    List<Report> selectByExample(ReportExample example);

    /**
     * 根据指定主键获取一条数据库记录,t_report
     *
     * @param subId
     * @param reportType
     */
    Report selectByPrimaryKey(@Param("reportSubId") String subId, @Param("reportType") Integer reportType);

    /**
     * 动态根据指定的条件来更新符合条件的数据库记录,t_report
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") Report record, @Param("example") ReportExample example);

    /**
     * ,t_report
     *
     * @param record
     * @param example
     */
    int updateByExampleWithBLOBs(@Param("record") Report record, @Param("example") ReportExample example);

    /**
     * 根据指定的条件来更新符合条件的数据库记录,t_report
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") Report record, @Param("example") ReportExample example);

    /**
     * 动态字段,根据主键来更新符合条件的数据库记录,t_report
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Report record);

    /**
     * ,t_report
     *
     * @param record
     */
    int updateByPrimaryKeyWithBLOBs(Report record);

    /**
     * 根据主键来更新符合条件的数据库记录,t_report
     *
     * @param record
     */
    int updateByPrimaryKey(Report record);

    int insertBatchSelective(List<Report> records);

    int updateBatchByPrimaryKeySelective(List<Report> records);
}