package org.nefure.goodshops.mapper;
import org.nefure.goodshops.entity.UserInfo;
import org.apache.ibatis.annotations.*;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author nefure
 * @since 2022/11/26 20:15
 */
public interface UserInfoMapper{
    String TABLE_NAME = "`tb_user_info`";

    /**
     * 添加一条记录
     * @param item 要添加的记录
     */
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    @Insert("<script>INSERT INTO " + TABLE_NAME + " VALUE (<choose><when test='userId != null'>#{userId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='city != null'>#{city}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='introduce != null'>#{introduce}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='fans != null'>#{fans}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='followee != null'>#{followee}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='gender != null'>#{gender}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='birthday != null'>#{birthday}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='credits != null'>#{credits}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='level != null'>#{level}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='createTime != null'>#{createTime}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='updateTime != null'>#{updateTime}</when><otherwise> DEFAULT </otherwise></choose>)</script>")
    void insert(UserInfo item);

    /**
     * 批量添加记录
     * @param items 要添加的记录集合
     */
    @Insert("<script><foreach collection='list' item='item' open=' INSERT INTO " + TABLE_NAME + " VALUE' separator=','>(<choose><when test='item.userId != null'>#{item.userId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.city != null'>#{item.city}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.introduce != null'>#{item.introduce}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.fans != null'>#{item.fans}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.followee != null'>#{item.followee}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.gender != null'>#{item.gender}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.birthday != null'>#{item.birthday}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.credits != null'>#{item.credits}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.level != null'>#{item.level}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.createTime != null'>#{item.createTime}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.updateTime != null'>#{item.updateTime}</when><otherwise> DEFAULT </otherwise></choose>)</foreach></script>")
    void insertAll(List<UserInfo> items);

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
    @Update("<script>UPDATE "+TABLE_NAME+" <set><if test='userId!=null'>`user_id`=#{userId},</if><if test='city!=null'>`city`=#{city},</if><if test='introduce!=null'>`introduce`=#{introduce},</if><if test='fans!=null'>`fans`=#{fans},</if><if test='followee!=null'>`followee`=#{followee},</if><if test='gender!=null'>`gender`=#{gender},</if><if test='birthday!=null'>`birthday`=#{birthday},</if><if test='credits!=null'>`credits`=#{credits},</if><if test='level!=null'>`level`=#{level},</if><if test='createTime!=null'>`create_time`=#{createTime},</if>update_time = NOW(),</set> WHERE `id` = #{id}</script>")
    int updateById(UserInfo item);

    /**
     * 根据id查询记录
     * @param id 主键
     * @return 记录封装类
     */
    @Select("SELECT `user_id`,`city`,`introduce`,`fans`,`followee`,`gender`,`birthday`,`credits`,`level`,`create_time`,`update_time` FROM "+TABLE_NAME+"WHERE `id`=#{id}")
    UserInfo selectById(Serializable id);

}