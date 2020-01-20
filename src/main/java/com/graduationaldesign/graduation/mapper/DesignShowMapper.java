package com.graduationaldesign.graduation.mapper;

import com.graduationaldesign.graduation.pojo.DesignShow;
import com.graduationaldesign.graduation.pojo.DesignShowExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface DesignShowMapper {
    /**
     *  根据指定的条件获取数据库记录数,t_designshow
     *
     * @param example
     */
    long countByExample(DesignShowExample example);

    /**
     *  根据指定的条件删除数据库符合条件的记录,t_designshow
     *
     * @param example
     */
    int deleteByExample(DesignShowExample example);

    /**
     *  根据主键删除数据库的记录,t_designshow
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,t_designshow
     *
     * @param record
     */
    int insert(DesignShow record);

    /**
     *  动态字段,写入数据库记录,t_designshow
     *
     * @param record
     */
    int insertSelective(DesignShow record);

    /**
     * ,t_designshow
     *
     * @param example
     */
    List<DesignShow> selectByExampleWithBLOBs(DesignShowExample example);

    /**
     *  根据指定的条件查询符合条件的数据库记录,t_designshow
     *
     * @param example
     */
    List<DesignShow> selectByExample(DesignShowExample example);

    /**
     *  根据指定主键获取一条数据库记录,t_designshow
     *
     * @param id
     */
    DesignShow selectByPrimaryKey(Integer id);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,t_designshow
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") DesignShow record, @Param("example") DesignShowExample example);

    /**
     * ,t_designshow
     *
     * @param record
     * @param example
     */
    int updateByExampleWithBLOBs(@Param("record") DesignShow record, @Param("example") DesignShowExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,t_designshow
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") DesignShow record, @Param("example") DesignShowExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,t_designshow
     *
     * @param record
     */
    int updateByPrimaryKeySelective(DesignShow record);

    /**
     * ,t_designshow
     *
     * @param record
     */
    int updateByPrimaryKeyWithBLOBs(DesignShow record);

    /**
     *  根据主键来更新符合条件的数据库记录,t_designshow
     *
     * @param record
     */
    int updateByPrimaryKey(DesignShow record);

    int insertBatchSelective(List<DesignShow> records);

    int updateBatchByPrimaryKeySelective(List<DesignShow> records);
}