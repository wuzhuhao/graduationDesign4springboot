package com.graduationaldesign.graduation.mapper;

import com.graduationaldesign.graduation.pojo.Comment;
import com.graduationaldesign.graduation.pojo.CommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CommentMapper {
    /**
     *  根据指定的条件获取数据库记录数,comment_
     *
     * @param example
     */
    long countByExample(CommentExample example);

    /**
     *  根据指定的条件删除数据库符合条件的记录,comment_
     *
     * @param example
     */
    int deleteByExample(CommentExample example);

    /**
     *  根据主键删除数据库的记录,comment_
     *
     * @param id
     */
    int deleteByPrimaryKey(Integer id);

    /**
     *  新写入数据库记录,comment_
     *
     * @param record
     */
    int insert(Comment record);

    /**
     *  动态字段,写入数据库记录,comment_
     *
     * @param record
     */
    int insertSelective(Comment record);

    /**
     * ,comment_
     *
     * @param example
     */
    List<Comment> selectByExampleWithBLOBs(CommentExample example);

    /**
     *  根据指定的条件查询符合条件的数据库记录,comment_
     *
     * @param example
     */
    List<Comment> selectByExample(CommentExample example);

    /**
     *  根据指定主键获取一条数据库记录,comment_
     *
     * @param id
     */
    Comment selectByPrimaryKey(Integer id);

    /**
     *  动态根据指定的条件来更新符合条件的数据库记录,comment_
     *
     * @param record
     * @param example
     */
    int updateByExampleSelective(@Param("record") Comment record, @Param("example") CommentExample example);

    /**
     * ,comment_
     *
     * @param record
     * @param example
     */
    int updateByExampleWithBLOBs(@Param("record") Comment record, @Param("example") CommentExample example);

    /**
     *  根据指定的条件来更新符合条件的数据库记录,comment_
     *
     * @param record
     * @param example
     */
    int updateByExample(@Param("record") Comment record, @Param("example") CommentExample example);

    /**
     *  动态字段,根据主键来更新符合条件的数据库记录,comment_
     *
     * @param record
     */
    int updateByPrimaryKeySelective(Comment record);

    /**
     * ,comment_
     *
     * @param record
     */
    int updateByPrimaryKeyWithBLOBs(Comment record);

    /**
     *  根据主键来更新符合条件的数据库记录,comment_
     *
     * @param record
     */
    int updateByPrimaryKey(Comment record);

    int insertBatchSelective(List<Comment> records);

    int updateBatchByPrimaryKeySelective(List<Comment> records);
}