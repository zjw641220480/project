package cn.itcast.zjw.project.mapper;

import cn.itcast.zjw.project.domain.Items;
import cn.itcast.zjw.project.domain.ItemsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ItemsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbggenerated Thu Dec 31 17:41:44 CST 2015
     */
    int countByExample(ItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbggenerated Thu Dec 31 17:41:44 CST 2015
     */
    int deleteByExample(ItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbggenerated Thu Dec 31 17:41:44 CST 2015
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbggenerated Thu Dec 31 17:41:44 CST 2015
     */
    int insert(Items record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbggenerated Thu Dec 31 17:41:44 CST 2015
     */
    int insertSelective(Items record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbggenerated Thu Dec 31 17:41:44 CST 2015
     */
    List<Items> selectByExampleWithBLOBs(ItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbggenerated Thu Dec 31 17:41:44 CST 2015
     */
    List<Items> selectByExample(ItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbggenerated Thu Dec 31 17:41:44 CST 2015
     */
    Items selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbggenerated Thu Dec 31 17:41:44 CST 2015
     */
    int updateByExampleSelective(@Param("record") Items record, @Param("example") ItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbggenerated Thu Dec 31 17:41:44 CST 2015
     */
    int updateByExampleWithBLOBs(@Param("record") Items record, @Param("example") ItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbggenerated Thu Dec 31 17:41:44 CST 2015
     */
    int updateByExample(@Param("record") Items record, @Param("example") ItemsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbggenerated Thu Dec 31 17:41:44 CST 2015
     */
    int updateByPrimaryKeySelective(Items record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbggenerated Thu Dec 31 17:41:44 CST 2015
     */
    int updateByPrimaryKeyWithBLOBs(Items record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table items
     *
     * @mbggenerated Thu Dec 31 17:41:44 CST 2015
     */
    int updateByPrimaryKey(Items record);
}