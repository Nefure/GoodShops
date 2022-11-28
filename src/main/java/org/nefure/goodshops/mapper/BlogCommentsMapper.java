package org.nefure.goodshops.mapper;
import org.nefure.goodshops.entity.BlogComments;
import org.apache.ibatis.annotations.*;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author nefure
 * @since 2022/11/26 20:15
 */
public interface BlogCommentsMapper{
    String TABLE_NAME = "`tb_blog_comments`";

    /**
     * 添加一条记录
     * @param item 要添加的记录
     */
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    @Insert("<script>INSERT INTO " + TABLE_NAME + " VALUE (<choose><when test='id != null'>#{id}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='userId != null'>#{userId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='blogId != null'>#{blogId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='parentId != null'>#{parentId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='answerId != null'>#{answerId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='content != null'>#{content}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='liked != null'>#{liked}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='status != null'>#{status}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='createTime != null'>#{createTime}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='updateTime != null'>#{updateTime}</when><otherwise> DEFAULT </otherwise></choose>)</script>")
    void insert(BlogComments item);

    /**
     * 批量添加记录
     * @param items 要添加的记录集合
     */
    @Insert("<script><foreach collection='list' item='item' open=' INSERT INTO " + TABLE_NAME + " VALUE' separator=','>(<choose><when test='item.id != null'>#{item.id}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.userId != null'>#{item.userId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.blogId != null'>#{item.blogId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.parentId != null'>#{item.parentId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.answerId != null'>#{item.answerId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.content != null'>#{item.content}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.liked != null'>#{item.liked}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.status != null'>#{item.status}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.createTime != null'>#{item.createTime}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.updateTime != null'>#{item.updateTime}</when><otherwise> DEFAULT </otherwise></choose>)</foreach></script>")
    void insertAll(List<BlogComments> items);

    /**
     * 根据id删除一条记录
     * @param id 主键
     */
    @Delete("DELETE FROM "+TABLE_NAME+" WHERE `id`=#{id}")
    void delete(Serializable id);

    /**
     * 根据id更新记录
     * @param item 需要更新的记录信息
     * @return 影响行数
     */
    @Update("<script>UPDATE "+TABLE_NAME+" <set><if test='id!=null'>`id`=#{id},</if><if test='userId!=null'>`user_id`=#{userId},</if><if test='blogId!=null'>`blog_id`=#{blogId},</if><if test='parentId!=null'>`parent_id`=#{parentId},</if><if test='answerId!=null'>`answer_id`=#{answerId},</if><if test='content!=null'>`content`=#{content},</if><if test='liked!=null'>`liked`=#{liked},</if><if test='status!=null'>`status`=#{status},</if><if test='createTime!=null'>`create_time`=#{createTime},</if>update_time = NOW(),</set> WHERE `id` = #{id}</script>")
    int updateById(BlogComments item);

    /**
     * 根据id查询记录
     * @param id 主键
     * @return 记录封装类
     */
    @Select("SELECT `id`,`user_id`,`blog_id`,`parent_id`,`answer_id`,`content`,`liked`,`status`,`create_time`,`update_time` FROM "+TABLE_NAME+"WHERE `id`=#{id}")
    BlogComments selectById(Serializable id);

}