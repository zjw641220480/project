package org.tom.util.xml;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
@XmlAccessorType(XmlAccessType.FIELD)  
@XmlRootElement(name="xml")
@XmlType(propOrder = { "appid", "prepayid", "partnerid", "noncestr","sign","timestamp","pkg" })
public class WeChatDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String appid;
	@XmlElement(name = "prepay_id")
	private String prepayid;
	@XmlElement(name = "mch_id")
	private String partnerid;
	@XmlElement(name = "nonce_str")
	private String noncestr;

	private String timestamp=(System.currentTimeMillis()+"").substring(0, 10);

	private String pkg="Sign=WXPay";
	
	private String sign;
	
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getPrepayid() {
		return prepayid;
	}
	public void setPrepayid(String prepayid) {
		this.prepayid = prepayid;
	}
	public String getPartnerid() {
		return partnerid;
	}
	public void setPartnerid(String partnerid) {
		this.partnerid = partnerid;
	}
	public String getNoncestr() {
		return noncestr;
	}
	public void setNoncestr(String noncestr) {
		this.noncestr = noncestr;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getPkg() {
		return pkg;
	}

}
