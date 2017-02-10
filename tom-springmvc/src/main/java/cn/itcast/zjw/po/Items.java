package cn.itcast.zjw.po;

import java.util.Date;

import javax.validation.constraints.Size;

public class Items {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ITEMS.ID
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    private Integer id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ITEMS.NAME
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    @Size(min=6,max=30,message="{items.name.length.error}")
    private String name;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ITEMS.PRICE
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    private Integer price;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ITEMS.PIC
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    private String pic;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ITEMS.CREATETIME
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column ITEMS.DETAIL
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    private String detail;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ITEMS.ID
     *
     * @return the value of ITEMS.ID
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ITEMS.ID
     *
     * @param id the value for ITEMS.ID
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ITEMS.NAME
     *
     * @return the value of ITEMS.NAME
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ITEMS.NAME
     *
     * @param name the value for ITEMS.NAME
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ITEMS.PRICE
     *
     * @return the value of ITEMS.PRICE
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    public Integer getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ITEMS.PRICE
     *
     * @param price the value for ITEMS.PRICE
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    public void setPrice(Integer price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ITEMS.PIC
     *
     * @return the value of ITEMS.PIC
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    public String getPic() {
        return pic;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ITEMS.PIC
     *
     * @param pic the value for ITEMS.PIC
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    public void setPic(String pic) {
        this.pic = pic == null ? null : pic.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ITEMS.CREATETIME
     *
     * @return the value of ITEMS.CREATETIME
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ITEMS.CREATETIME
     *
     * @param createtime the value for ITEMS.CREATETIME
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column ITEMS.DETAIL
     *
     * @return the value of ITEMS.DETAIL
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    public String getDetail() {
        return detail;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column ITEMS.DETAIL
     *
     * @param detail the value for ITEMS.DETAIL
     *
     * @mbggenerated Sat Feb 04 16:31:43 CST 2017
     */
    public void setDetail(String detail) {
        this.detail = detail == null ? null : detail.trim();
    }
}