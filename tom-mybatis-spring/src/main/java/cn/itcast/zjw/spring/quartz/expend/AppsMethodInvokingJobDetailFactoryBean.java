package cn.itcast.zjw.spring.quartz.expend;

import java.util.Date;

import org.apache.log4j.Logger;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.JobDetailFactoryBean;
import org.springframework.scheduling.quartz.MethodInvokingJobDetailFactoryBean;
import org.springframework.util.MethodInvoker;

public class AppsMethodInvokingJobDetailFactoryBean extends MethodInvokingJobDetailFactoryBean {
	protected static final Logger logger = Logger.getLogger(AppsMethodInvokingJobDetailFactoryBean.class);
	@Override  
    public void afterPropertiesSet() throws ClassNotFoundException,  
            NoSuchMethodException {  
        super.afterPropertiesSet();  
        
        logger.info(""+super.getObject().getJobClass().getName());
        // Consider the concurrent flag to choose between stateful and stateless job.  
        if(MethodInvokingJob.class.getName().equals((super.getObject()).getJobClass().getName())) {
            ((JobDetailFactoryBean) super.getObject()).setJobClass(AppsMethodInvokingJobDetailFactoryBean.class);  
        } else {  
            ((JobDetailFactoryBean)super.getObject()).setJobClass(AppsStatefulMethodInvokingJob.class);  
        }  
        logger.info("new jobClass : " + ((JobDetail)super.getObject()).getJobClass().getName());  
    } 
	
	public static class AppsMethodInvokingJob extends MethodInvokingJob {  
		protected static final Logger logger = Logger.getLogger(AppsMethodInvokingJob.class);
        private MethodInvoker methodInvoker;  
        private String errorMessage;  
  
        /** 
         * Set the MethodInvoker to use. 
         */  
        public void setMethodInvoker(MethodInvoker methodInvoker) {  
            this.methodInvoker = methodInvoker;  
            this.errorMessage = "Could not invoke method '" + this.methodInvoker.getTargetMethod() +  
                    "' on target object [" + this.methodInvoker.getTargetObject() + "]";  
        }  
  
        /** 
         * Invoke the method via the MethodInvoker. 
         */  
        protected void executeInternal(JobExecutionContext context) throws JobExecutionException {  
            Date startDate = new Date();  
            String taskName = methodInvoker.getTargetClass().getName();  
            try {  
                if (logger.isInfoEnabled()) {  
                    logger.info(taskName + " job start at " + startDate);  
                }  
                  
                //根据当前服务器主机名或者IP判断是否需要执行该任务  
                //TODO Code  
                
                //调用具体task执行method代码  
                this.methodInvoker.invoke();                 
            } catch (Exception ex) {  
                logger.error(taskName + " accounted a error : " + this.errorMessage, ex);  
                throw new JobExecutionException(this.errorMessage, ex, false);  
            } finally {  
                if(logger.isInfoEnabled()) {  
                    logger.info(taskName + " job end   at " + new Date());  
                }  
                  
                //将task执行结果taskResult进行持久化、或者通知相关owner  
                //TODO Code  
            }  
        }  
    }  
  
    public static class AppsStatefulMethodInvokingJob extends AppsMethodInvokingJob {  
    }  
}
