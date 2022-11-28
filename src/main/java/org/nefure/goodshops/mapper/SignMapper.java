package org.nefure.goodshops.mapper;
import org.nefure.goodshops.entity.Sign;
import org.apache.ibatis.annotations.*;
import java.io.Serializable;
import java.util.List;
/**
 *
 * @author nefure
 * @since 2022/11/26 20:15
 */
public interface SignMapper{
    String TABLE_NAME = "`tb_sign`";

    /**
     * 添加一条记录
     * @param item 要添加的记录
     */
    @Options(useGeneratedKeys=true, keyProperty="id", keyColumn="id")
    @Insert("<script>INSERT INTO " + TABLE_NAME + " VALUE (<choose><when test='id != null'>#{id}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='userId != null'>#{userId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='year != null'>#{year}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='month != null'>#{month}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='date != null'>#{date}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='isBackup != null'>#{isBackup}</when><otherwise> DEFAULT </otherwise></choose>)</script>")
    void insert(Sign item);

    /**
     * 批量添加记录
     * @param items 要添加的记录集合
     */
    @Insert("<script><foreach collection='list' item='item' open=' INSERT INTO " + TABLE_NAME + " VALUE' separator=','>(<choose><when test='item.id != null'>#{item.id}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.userId != null'>#{item.userId}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.year != null'>#{item.year}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.month != null'>#{item.month}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.date != null'>#{item.date}</when><otherwise> DEFAULT </otherwise></choose>,<choose><when test='item.isBackup != null'>#{item.isBackup}</when><otherwise> DEFAULT </otherwise></choose>)</foreach></script>")
    void insertAll(List<Sign> items);

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
    @Update("<script>UPDATE "+TABLE_NAME+" <set><if test='id!=null'>`id`=#{id},</if><if test='userId!=null'>`user_id`=#{userId},</if><if test='year!=null'>`year`=#{year},</if><if test='month!=null'>`month`=#{month},</if><if test='date!=null'>`date`=#{date},</if><if test='isBackup!=null'>`is_backup`=#{isBackup},</if></set> WHERE `id` = #{id}</script>")
    int updateById(Sign item);

    /**
     * 根据id查询记录
     * @param id 主键
     * @return 记录封装类
     */
    @Select("SELECT `id`,`user_id`,`year`,`month`,`date`,`is_backup` FROM "+TABLE_NAME+"WHERE `id`=#{id}")
    Sign selectById(Serializable id);

}