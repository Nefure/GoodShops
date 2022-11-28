package org.nefure.goodshops.mapper;
import org.nefure.goodshops.entity.VoucherOrder;
import org.apache.ibatis.annotations.*;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author nefure
 * @since 2022/11/26 20:15
 */
public interface VoucherOrderMapper{
    String TABLE_NAME = "`tb_voucher_order`";

    /**
     * 添加一条记录
     * @param item 要添加的记录
     */
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    @Insert("<script>INSERT INTO " + TABLE_NAME + " VALUE (<choose><when test='id != null'>#{id}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='userId != null'>#{userId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='voucherId != null'>#{voucherId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='payType != null'>#{payType}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='status != null'>#{status}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='createTime != null'>#{createTime}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='payTime != null'>#{payTime}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='useTime != null'>#{useTime}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='refundTime != null'>#{refundTime}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='updateTime != null'>#{updateTime}</when><otherwise> DEFAULT </otherwise></choose>)</script>")
    void insert(VoucherOrder item);

    /**
     * 批量添加记录
     * @param items 要添加的记录集合
     */
    @Insert("<script><foreach collection='list' item='item' open=' INSERT INTO " + TABLE_NAME + " VALUE' separator=','>(<choose><when test='item.id != null'>#{item.id}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.userId != null'>#{item.userId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.voucherId != null'>#{item.voucherId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.payType != null'>#{item.payType}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.status != null'>#{item.status}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.createTime != null'>#{item.createTime}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.payTime != null'>#{item.payTime}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.useTime != null'>#{item.useTime}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.refundTime != null'>#{item.refundTime}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.updateTime != null'>#{item.updateTime}</when><otherwise> DEFAULT </otherwise></choose>)</foreach></script>")
    void insertAll(List<VoucherOrder> items);

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
    @Update("<script>UPDATE "+TABLE_NAME+" <set><if test='id!=null'>`id`=#{id},</if><if test='userId!=null'>`user_id`=#{userId},</if><if test='voucherId!=null'>`voucher_id`=#{voucherId},</if><if test='payType!=null'>`pay_type`=#{payType},</if><if test='status!=null'>`status`=#{status},</if><if test='createTime!=null'>`create_time`=#{createTime},</if><if test='payTime!=null'>`pay_time`=#{payTime},</if><if test='useTime!=null'>`use_time`=#{useTime},</if><if test='refundTime!=null'>`refund_time`=#{refundTime},</if>update_time = NOW(),</set> WHERE `id` = #{id}</script>")
    int updateById(VoucherOrder item);

    /**
     * 根据id查询记录
     * @param id 主键
     * @return 记录封装类
     */
    @Select("SELECT `id`,`user_id`,`voucher_id`,`pay_type`,`status`,`create_time`,`pay_time`,`use_time`,`refund_time`,`update_time` FROM "+TABLE_NAME+"WHERE `id`=#{id}")
    VoucherOrder selectById(Serializable id);

}