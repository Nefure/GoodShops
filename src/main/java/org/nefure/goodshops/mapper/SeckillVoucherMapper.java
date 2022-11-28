package org.nefure.goodshops.mapper;
import org.nefure.goodshops.entity.SeckillVoucher;
import org.apache.ibatis.annotations.*;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author nefure
 * @since 2022/11/26 20:15
 */
public interface SeckillVoucherMapper{
    String TABLE_NAME = "`tb_seckill_voucher`";

    /**
     * 添加一条记录
     * @param item 要添加的记录
     */
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    @Insert("<script>INSERT INTO " + TABLE_NAME + " VALUE (<choose><when test='voucherId != null'>#{voucherId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='stock != null'>#{stock}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='createTime != null'>#{createTime}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='beginTime != null'>#{beginTime}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='endTime != null'>#{endTime}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='updateTime != null'>#{updateTime}</when><otherwise> DEFAULT </otherwise></choose>)</script>")
    void insert(SeckillVoucher item);

    /**
     * 批量添加记录
     * @param items 要添加的记录集合
     */
    @Insert("<script><foreach collection='list' item='item' open=' INSERT INTO " + TABLE_NAME + " VALUE' separator=','>(<choose><when test='item.voucherId != null'>#{item.voucherId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.stock != null'>#{item.stock}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.createTime != null'>#{item.createTime}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.beginTime != null'>#{item.beginTime}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.endTime != null'>#{item.endTime}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.updateTime != null'>#{item.updateTime}</when><otherwise> DEFAULT </otherwise></choose>)</foreach></script>")
    void insertAll(List<SeckillVoucher> items);

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
    @Update("<script>UPDATE "+TABLE_NAME+" <set><if test='voucherId!=null'>`voucher_id`=#{voucherId},</if><if test='stock!=null'>`stock`=#{stock},</if><if test='createTime!=null'>`create_time`=#{createTime},</if><if test='beginTime!=null'>`begin_time`=#{beginTime},</if><if test='endTime!=null'>`end_time`=#{endTime},</if>update_time = NOW(),</set> WHERE `id` = #{id}</script>")
    int updateById(SeckillVoucher item);

    /**
     * 根据id查询记录
     * @param id 主键
     * @return 记录封装类
     */
    @Select("SELECT `voucher_id`,`stock`,`create_time`,`begin_time`,`end_time`,`update_time` FROM "+TABLE_NAME+"WHERE `id`=#{id}")
    SeckillVoucher selectById(Serializable id);

}