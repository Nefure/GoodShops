package org.nefure.goodshops.mapper;
import org.nefure.goodshops.entity.Voucher;
import org.apache.ibatis.annotations.*;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author nefure
 * @since 2022/11/26 20:15
 */
public interface VoucherMapper{
    String TABLE_NAME = "`tb_voucher`";

    /**
     * 添加一条记录
     * @param item 要添加的记录
     */
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    @Insert("<script>INSERT INTO " + TABLE_NAME + " VALUE (<choose><when test='id != null'>#{id}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='shopId != null'>#{shopId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='title != null'>#{title}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='subTitle != null'>#{subTitle}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='rules != null'>#{rules}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='payValue != null'>#{payValue}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='actualValue != null'>#{actualValue}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='type != null'>#{type}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='status != null'>#{status}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='createTime != null'>#{createTime}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='updateTime != null'>#{updateTime}</when><otherwise> DEFAULT </otherwise></choose>)</script>")
    void insert(Voucher item);

    /**
     * 批量添加记录
     * @param items 要添加的记录集合
     */
    @Insert("<script><foreach collection='list' item='item' open=' INSERT INTO " + TABLE_NAME + " VALUE' separator=','>(<choose><when test='item.id != null'>#{item.id}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.shopId != null'>#{item.shopId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.title != null'>#{item.title}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.subTitle != null'>#{item.subTitle}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.rules != null'>#{item.rules}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.payValue != null'>#{item.payValue}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.actualValue != null'>#{item.actualValue}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.type != null'>#{item.type}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.status != null'>#{item.status}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.createTime != null'>#{item.createTime}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.updateTime != null'>#{item.updateTime}</when><otherwise> DEFAULT </otherwise></choose>)</foreach></script>")
    void insertAll(List<Voucher> items);

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
    @Update("<script>UPDATE "+TABLE_NAME+" <set><if test='id!=null'>`id`=#{id},</if><if test='shopId!=null'>`shop_id`=#{shopId},</if><if test='title!=null'>`title`=#{title},</if><if test='subTitle!=null'>`sub_title`=#{subTitle},</if><if test='rules!=null'>`rules`=#{rules},</if><if test='payValue!=null'>`pay_value`=#{payValue},</if><if test='actualValue!=null'>`actual_value`=#{actualValue},</if><if test='type!=null'>`type`=#{type},</if><if test='status!=null'>`status`=#{status},</if><if test='createTime!=null'>`create_time`=#{createTime},</if>update_time = NOW(),</set> WHERE `id` = #{id}</script>")
    int updateById(Voucher item);

    /**
     * 根据id查询记录
     * @param id 主键
     * @return 记录封装类
     */
    @Select("SELECT `id`,`shop_id`,`title`,`sub_title`,`rules`,`pay_value`,`actual_value`,`type`,`status`,`create_time`,`update_time` FROM "+TABLE_NAME+"WHERE `id`=#{id}")
    Voucher selectById(Serializable id);

}