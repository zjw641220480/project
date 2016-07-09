/**
 * @Project: tom-mybatis-spring @(#) Job.java
 * 
 * Copyright (c) 2016, Credan-版权所有
 * 
 */
package cn.itcast.zjw.spring.quartz;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

/** 
 * @ClassName: Job
 * @Description:
 * @Time 2016年5月24日 下午9:44:45
 * @author: TOM
 * @version 1.0.0
 * @since  1.6
 */
public class Job extends QuartzJobBean{
	private int timeout;  
	private static int i = 0;  
	//调度工厂实例化后，经过timeout时间开始执行调度  
	public void setTimeout(int timeout) {  
	this.timeout = timeout;  
	}  
	  
	/** 
	* 要调度的具体任务 
	*/  
	@Override  
	protected void executeInternal(JobExecutionContext context)  
	throws JobExecutionException {  
	  System.out.println("定时任务执行中…");  
	}  

}
