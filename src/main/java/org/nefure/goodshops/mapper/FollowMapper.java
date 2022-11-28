package org.nefure.goodshops.mapper;
import org.nefure.goodshops.entity.Follow;
import org.apache.ibatis.annotations.*;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author nefure
 * @since 2022/11/26 20:15
 */
public interface FollowMapper{
    String TABLE_NAME = "`tb_follow`";

    /**
     * 添加一条记录
     * @param item 要添加的记录
     */
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    @Insert("<script>INSERT INTO " + TABLE_NAME + " VALUE (<choose><when test='id != null'>#{id}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='userId != null'>#{userId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='followUserId != null'>#{followUserId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='createTime != null'>#{createTime}</when><otherwise> DEFAULT </otherwise></choose>)</script>")
    void insert(Follow item);

    /**
     * 批量添加记录
     * @param items 要添加的记录集合
     */
    @Insert("<script><foreach collection='list' item='item' open=' INSERT INTO " + TABLE_NAME + " VALUE' separator=','>(<choose><when test='item.id != null'>#{item.id}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.userId != null'>#{item.userId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.followUserId != null'>#{item.followUserId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.createTime != null'>#{item.createTime}</when><otherwise> DEFAULT </otherwise></choose>)</foreach></script>")
    void insertAll(List<Follow> items);

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
    @Update("<script>UPDATE "+TABLE_NAME+" <set><if test='id!=null'>`id`=#{id},</if><if test='userId!=null'>`user_id`=#{userId},</if><if test='followUserId!=null'>`follow_user_id`=#{followUserId},</if><if test='createTime!=null'>`create_time`=#{createTime},</if></set> WHERE `id` = #{id}</script>")
    int updateById(Follow item);

    /**
     * 根据id查询记录
     * @param id 主键
     * @return 记录封装类
     */
    @Select("SELECT `id`,`user_id`,`follow_user_id`,`create_time` FROM "+TABLE_NAME+"WHERE `id`=#{id}")
    Follow selectById(Serializable id);

}