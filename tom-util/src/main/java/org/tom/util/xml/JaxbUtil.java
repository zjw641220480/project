package org.tom.util.xml;

import java.io.StringReader;
import java.io.StringWriter;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class JaxbUtil {
	private JaxbUtil() {}
	/** 
     * JavaBean转换成xml 
     * 默认编码UTF-8 
     * @param obj 
     * @param writer 
     * @return  
     */  
    public static String convertToXml(Object obj) {  
        return convertToXml(obj, "UTF-8");  
    }  
  
    /** 
     * JavaBean转换成xml 
     * @param obj 
     * @param encoding  
     * @return  
     */  
    public static String convertToXml(Object obj, String encoding) {  
        String result = null;  
        try {  
            JAXBContext context = JAXBContext.newInstance(obj.getClass());  
            Marshaller marshaller = context.createMarshaller();  
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
            marshaller.setProperty(Marshaller.JAXB_ENCODING, encoding);  
  
            StringWriter writer = new StringWriter();  
            marshaller.marshal(obj, writer);  
            result = writer.toString();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return result;  
    }  
  
    /** 
     * xml转换成JavaBean 
     * @param xml 
     * @param c 
     * @return 
     */  
    @SuppressWarnings("unchecked")  
    public static <T> T converyToJavaBean(String xml, Class<T> c) {  
        T t = null;  
        try {  
            JAXBContext context = JAXBContext.newInstance(c);  
            Unmarshaller unmarshaller = context.createUnmarshaller();  
            t = (T) unmarshaller.unmarshal(new StringReader(xml));  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        return t;  
    }  
    public static void main(String[] args) {
		String xml = "<xml><return_code><![CDATA[SUCCESS]]></return_code>\r\n" + 
				"<return_msg><![CDATA[OK]]></return_msg>\r\n" + 
				"<appid><![CDATA[wx1a3bc6152cb94414]]></appid>\r\n" + 
				"<mch_id><![CDATA[1487537442]]></mch_id>\r\n" + 
				"<device_info><![CDATA[WEB]]></device_info>\r\n" + 
				"<nonce_str><![CDATA[AcMwlq6OZAZW51LM]]></nonce_str>\r\n" + 
				"<sign><![CDATA[8CA7A132357BE96F9D4BEA699AB7BB11]]></sign>\r\n" + 
				"<result_code><![CDATA[SUCCESS]]></result_code>\r\n" + 
				"<prepay_id><![CDATA[wx20170828114556f3991723dc0172507575]]></prepay_id>\r\n" + 
				"<trade_type><![CDATA[APP]]></trade_type>\r\n" + 
				"</xml>";
		JaxbUtil.converyToJavaBean(xml, WeChatDto.class);
	}
}
