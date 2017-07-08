package cn.itcast.zjw.aop.xml;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * 
 * <p>Titile:Aspect</p>
 * <p>Description:切面类 </p>
 * @author TOM
 * @date 2017年7月8日 上午8:03:01
 */
@org.aspectj.lang.annotation.Aspect//声明切面
public class Aspect {
	/**
	 * 此注解用于声明切入点,
	 * 在Aspct注解风格的Aop中一个切入点签名通过普通的方法来定义,其有以下几点要求
	 * 	1:作为切入点签名的方法必须返回void
	 *  2:方法没有参数,并且为private;
	 *  3:方法体为空
	 * 
	 * 切入点表达式的写法:
	 * execution(* cn.itcast.zjw.aop..*.*(..))
	 * execution(* cn.itcast.zjw.aop.*.*.*(..))
	 * 	第一个*:表示方法的返回值可以任意
	 *  第二和第三个*:表示前面路径下的包及其子包中的所有的类;其也可以直接使用..*来表示此包以及子包下的所有类
	 *  第四个*:表示类中的所有方法,前加save,表示所有以save开头的方法
	 *  
	 * @MethodName:aspect
	 * @Description:
	 * @Time: 2017年7月8日 上午8:41:43
	 * @author: TOM
	 */
	@Pointcut("execution(* cn.itcast.zjw.aop..*.run*(..))")
	private void  aspect() {}
	/**
	 * Before前置通知,在方法调用前执行
	 * aspect()标识了前面定义的切入点方法,
	 * @MethodName:beforeMethod
	 * @Description:
	 * @Time: 2017年7月8日 上午8:49:44
	 * @author: TOM
	 */
	@Before("aspect()")
	public void beforeMethod(){
		System.out.println("Aspect.beforeMethod()");
	}
	/**
	 * AfterReturning:后置通知,在一个匹配的方法返回的时候执行
	 * pointcut:切入点
	 * returning:表示方法的返回值,方法无返回值的时候,返回值为空;
	 * 这一个才是最后运行的;在finally运行之后;
	 * @MethodName:afterMethod
	 * @Description:
	 * @Time: 2017年7月8日 上午8:53:17
	 * @author: TOM
	 */
	@AfterReturning(pointcut = "aspect()",returning="value")
	public void afterMethod(){
		System.out.println("Aspect.afterMethod()");
	}
	/**
	 * AfterThrowing:异常通知
	 * throwing:表示抛出的异常
	 * @MethodName:exceptionMethod
	 * @Description:
	 * @param ex
	 * @Time: 2017年7月8日 上午8:56:09
	 * @author: TOM
	 */
	@AfterThrowing(pointcut = "aspect()",throwing="ex")
	public void exceptionMethod(Exception ex){
		System.out.println("Aspect.exceptionMethod()");
		System.out.println(ex.getMessage());
	}
	/**
	 * After:最终通知,最终通知必须准备处理正常和异常两种情况,通常用它来释放资源;
	 * 它并不是最后一个运行的;
	 * @MethodName:finallyMethod
	 * @Description:
	 * @Time: 2017年7月8日 上午8:58:31
	 * @author: TOM
	 */
	@After("aspect()")
	public void finallyMethod(){
		System.out.println("Aspect.finallyMethod()");
	}
}
