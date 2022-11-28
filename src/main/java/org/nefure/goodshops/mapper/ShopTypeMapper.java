package org.nefure.goodshops.mapper;
import org.nefure.goodshops.entity.ShopType;
import org.apache.ibatis.annotations.*;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author nefure
 * @since 2022/11/26 20:15
 */
public interface ShopTypeMapper{
    String TABLE_NAME = "`tb_shop_type`";

    /**
     * 添加一条记录
     * @param item 要添加的记录
     */
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    @Insert("<script>INSERT INTO " + TABLE_NAME + " VALUE (<choose><when test='id != null'>#{id}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='name != null'>#{name}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='icon != null'>#{icon}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='sort != null'>#{sort}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='createTime != null'>#{createTime}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='updateTime != null'>#{updateTime}</when><otherwise> DEFAULT </otherwise></choose>)</script>")
    void insert(ShopType item);

    /**
     * 批量添加记录
     * @param items 要添加的记录集合
     */
    @Insert("<script><foreach collection='list' item='item' open=' INSERT INTO " + TABLE_NAME + " VALUE' separator=','>(<choose><when test='item.id != null'>#{item.id}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.name != null'>#{item.name}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.icon != null'>#{item.icon}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.sort != null'>#{item.sort}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.createTime != null'>#{item.createTime}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.updateTime != null'>#{item.updateTime}</when><otherwise> DEFAULT </otherwise></choose>)</foreach></script>")
    void insertAll(List<ShopType> items);

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
    @Update("<script>UPDATE "+TABLE_NAME+" <set><if test='id!=null'>`id`=#{id},</if><if test='name!=null'>`name`=#{name},</if><if test='icon!=null'>`icon`=#{icon},</if><if test='sort!=null'>`sort`=#{sort},</if><if test='createTime!=null'>`create_time`=#{createTime},</if>update_time = NOW(),</set> WHERE `id` = #{id}</script>")
    int updateById(ShopType item);

    /**
     * 根据id查询记录
     * @param id 主键
     * @return 记录封装类
     */
    @Select("SELECT `id`,`name`,`icon`,`sort`,`create_time`,`update_time` FROM "+TABLE_NAME+"WHERE `id`=#{id}")
    ShopType selectById(Serializable id);

}