package org.nefure.goodshops.mapper;
import org.nefure.goodshops.entity.Blog;
import org.apache.ibatis.annotations.*;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author nefure
 * @since 2022/11/26 20:15
 */
public interface BlogMapper{
    String TABLE_NAME = "`tb_blog`";

    /**
     * 添加一条记录
     * @param item 要添加的记录
     */
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    @Insert("<script>INSERT INTO " + TABLE_NAME + " VALUE (<choose><when test='id != null'>#{id}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='shopId != null'>#{shopId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='userId != null'>#{userId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='title != null'>#{title}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='images != null'>#{images}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='content != null'>#{content}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='liked != null'>#{liked}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='comments != null'>#{comments}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='createTime != null'>#{createTime}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='updateTime != null'>#{updateTime}</when><otherwise> DEFAULT </otherwise></choose>)</script>")
    void insert(Blog item);

    /**
     * 批量添加记录
     * @param items 要添加的记录集合
     */
    @Insert("<script><foreach collection='list' item='item' open=' INSERT INTO " + TABLE_NAME + " VALUE' separator=','>(<choose><when test='item.id != null'>#{item.id}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.shopId != null'>#{item.shopId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.userId != null'>#{item.userId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.title != null'>#{item.title}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.images != null'>#{item.images}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.content != null'>#{item.content}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.liked != null'>#{item.liked}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.comments != null'>#{item.comments}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.createTime != null'>#{item.createTime}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.updateTime != null'>#{item.updateTime}</when><otherwise> DEFAULT </otherwise></choose>)</foreach></script>")
    void insertAll(List<Blog> items);

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
    @Update("<script>UPDATE "+TABLE_NAME+" <set><if test='id!=null'>`id`=#{id},</if><if test='shopId!=null'>`shop_id`=#{shopId},</if><if test='userId!=null'>`user_id`=#{userId},</if><if test='title!=null'>`title`=#{title},</if><if test='images!=null'>`images`=#{images},</if><if test='content!=null'>`content`=#{content},</if><if test='liked!=null'>`liked`=#{liked},</if><if test='comments!=null'>`comments`=#{comments},</if><if test='createTime!=null'>`create_time`=#{createTime},</if>update_time = NOW(),</set> WHERE `id` = #{id}</script>")
    int updateById(Blog item);

    /**
     * 根据id查询记录
     * @param id 主键
     * @return 记录封装类
     */
    @Select("SELECT `id`,`shop_id`,`user_id`,`title`,`images`,`content`,`liked`,`comments`,`create_time`,`update_time` FROM "+TABLE_NAME+"WHERE `id`=#{id}")
    Blog selectById(Serializable id);

}