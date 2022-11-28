package org.nefure.goodshops.mapper;
import org.nefure.goodshops.entity.Shop;
import org.apache.ibatis.annotations.*;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author nefure
 * @since 2022/11/26 20:15
 */
public interface ShopMapper{
    String TABLE_NAME = "`tb_shop`";

    /**
     * 添加一条记录
     * @param item 要添加的记录
     */
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    @Insert("<script>INSERT INTO " + TABLE_NAME + " VALUE (<choose><when test='id != null'>#{id}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='name != null'>#{name}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='typeId != null'>#{typeId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='images != null'>#{images}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='area != null'>#{area}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='address != null'>#{address}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='x != null'>#{x}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='y != null'>#{y}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='avgPrice != null'>#{avgPrice}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='sold != null'>#{sold}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='comments != null'>#{comments}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='score != null'>#{score}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='openHours != null'>#{openHours}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='createTime != null'>#{createTime}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='updateTime != null'>#{updateTime}</when><otherwise> DEFAULT </otherwise></choose>)</script>")
    void insert(Shop item);

    /**
     * 批量添加记录
     * @param items 要添加的记录集合
     */
    @Insert("<script><foreach collection='list' item='item' open=' INSERT INTO " + TABLE_NAME + " VALUE' separator=','>(<choose><when test='item.id != null'>#{item.id}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.name != null'>#{item.name}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.typeId != null'>#{item.typeId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.images != null'>#{item.images}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.area != null'>#{item.area}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.address != null'>#{item.address}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.x != null'>#{item.x}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.y != null'>#{item.y}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.avgPrice != null'>#{item.avgPrice}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.sold != null'>#{item.sold}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.comments != null'>#{item.comments}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.score != null'>#{item.score}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.openHours != null'>#{item.openHours}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.createTime != null'>#{item.createTime}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.updateTime != null'>#{item.updateTime}</when><otherwise> DEFAULT </otherwise></choose>)</foreach></script>")
    void insertAll(List<Shop> items);

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
    @Update("<script>UPDATE "+TABLE_NAME+" <set><if test='id!=null'>`id`=#{id},</if><if test='name!=null'>`name`=#{name},</if><if test='typeId!=null'>`type_id`=#{typeId},</if><if test='images!=null'>`images`=#{images},</if><if test='area!=null'>`area`=#{area},</if><if test='address!=null'>`address`=#{address},</if><if test='x!=null'>`x`=#{x},</if><if test='y!=null'>`y`=#{y},</if><if test='avgPrice!=null'>`avg_price`=#{avgPrice},</if><if test='sold!=null'>`sold`=#{sold},</if><if test='comments!=null'>`comments`=#{comments},</if><if test='score!=null'>`score`=#{score},</if><if test='openHours!=null'>`open_hours`=#{openHours},</if><if test='createTime!=null'>`create_time`=#{createTime},</if>update_time = NOW(),</set> WHERE `id` = #{id}</script>")
    int updateById(Shop item);

    /**
     * 根据id查询记录
     * @param id 主键
     * @return 记录封装类
     */
    @Select("SELECT `id`,`name`,`type_id`,`images`,`area`,`address`,`x`,`y`,`avg_price`,`sold`,`comments`,`score`,`open_hours`,`create_time`,`update_time` FROM "+TABLE_NAME+"WHERE `id`=#{id}")
    Shop selectById(Serializable id);

}