package org.tom.util.date;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	/** 
	 * @MethodName:formatNow
	 * @Desription:格式化当前时间
	 * @date:2016年5月25日
	 * @author TOM
	 * @return  
	 */
	public static String formatNow(){
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return simpleDateFormat.format(date);
	}
}	
