package cn.itcast.zjw.shiro.po;

public class SysUserRole {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_role.id
     *
     * @mbggenerated Wed Jun 29 21:33:43 GMT+08:00 2016
     */
    private String id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_role.sys_user_id
     *
     * @mbggenerated Wed Jun 29 21:33:43 GMT+08:00 2016
     */
    private String sysUserId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user_role.sys_role_id
     *
     * @mbggenerated Wed Jun 29 21:33:43 GMT+08:00 2016
     */
    private String sysRoleId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_role.id
     *
     * @return the value of sys_user_role.id
     *
     * @mbggenerated Wed Jun 29 21:33:43 GMT+08:00 2016
     */
    public String getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_role.id
     *
     * @param id the value for sys_user_role.id
     *
     * @mbggenerated Wed Jun 29 21:33:43 GMT+08:00 2016
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_role.sys_user_id
     *
     * @return the value of sys_user_role.sys_user_id
     *
     * @mbggenerated Wed Jun 29 21:33:43 GMT+08:00 2016
     */
    public String getSysUserId() {
        return sysUserId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_role.sys_user_id
     *
     * @param sysUserId the value for sys_user_role.sys_user_id
     *
     * @mbggenerated Wed Jun 29 21:33:43 GMT+08:00 2016
     */
    public void setSysUserId(String sysUserId) {
        this.sysUserId = sysUserId == null ? null : sysUserId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_user_role.sys_role_id
     *
     * @return the value of sys_user_role.sys_role_id
     *
     * @mbggenerated Wed Jun 29 21:33:43 GMT+08:00 2016
     */
    public String getSysRoleId() {
        return sysRoleId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_user_role.sys_role_id
     *
     * @param sysRoleId the value for sys_user_role.sys_role_id
     *
     * @mbggenerated Wed Jun 29 21:33:43 GMT+08:00 2016
     */
    public void setSysRoleId(String sysRoleId) {
        this.sysRoleId = sysRoleId == null ? null : sysRoleId.trim();
    }
}