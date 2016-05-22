/**
 * @Project: tom-util @(#) LoggerUtil.java
 * 
 * Copyright (c) 2016, Credan-版权所有
 * 
 */
package org.tom.util.logger;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;

/** 
 * @ClassName: LoggerUtil
 * @Description:将日志信息写入日志文件
 * @Time 2016年5月21日 上午11:41:21
 * @author: TOM
 * @version 1.0.0
 * @since  1.6
 */
public class LoggerUtil {
	/**
	 * @Method: writeToLogger
	 * @Description:将日志信息写入日志文件
	 * @param: @param clazz
	 * @param: @param type
	 * @param: @param message 
	 * @return: void
	 * @date 2016年5月21日
	 * @author TOM
	 */
	public static void writeToLogger(Class<?> clazz,LoggerTypeEnum type,String message){
		Logger logger = Logger.getLogger(clazz);
		switch(type){
		case ERROR:
			logger.error(formatMessage(message));
			break;
		case WARN:
			logger.warn(formatMessage(message));
			break;
		case DEBUG:
			logger.debug(formatMessage(message));
			break;
		default:
			break;
		}
	}
	/**
	 * @Method: formatMessage
	 * @Description:格式化输出信息
	 * @param: @param message
	 * @param: @return 
	 * @return: String
	 * @date 2016年5月21日
	 * @author TOM
	 */
	private static String formatMessage(String message){
		SimpleDateFormat format = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		String date = format.format(new Date());
		return message+"\t时间:"+date;
	}
}
