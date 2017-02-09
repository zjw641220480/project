package cn.itcast.zjw.dao;

import cn.itcast.zjw.po.Users;
import cn.itcast.zjw.po.UsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UsersMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USERS
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    int countByExample(UsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USERS
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    int deleteByExample(UsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USERS
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USERS
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    int insert(Users record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USERS
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    int insertSelective(Users record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USERS
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    List<Users> selectByExample(UsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USERS
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    Users selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USERS
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    int updateByExampleSelective(@Param("record") Users record, @Param("example") UsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USERS
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    int updateByExample(@Param("record") Users record, @Param("example") UsersExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USERS
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    int updateByPrimaryKeySelective(Users record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table USERS
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    int updateByPrimaryKey(Users record);
}