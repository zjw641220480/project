package cn.itcast.zjw.dao;

import cn.itcast.zjw.po.Items;
import cn.itcast.zjw.po.ItemsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ITEMS
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    int countByExample(ItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ITEMS
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    int deleteByExample(ItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ITEMS
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ITEMS
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    int insert(Items record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ITEMS
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    int insertSelective(Items record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ITEMS
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    List<Items> selectByExample(ItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ITEMS
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    Items selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ITEMS
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    int updateByExampleSelective(@Param("record") Items record, @Param("example") ItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ITEMS
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    int updateByExample(@Param("record") Items record, @Param("example") ItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ITEMS
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    int updateByPrimaryKeySelective(Items record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table ITEMS
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    int updateByPrimaryKey(Items record);
}