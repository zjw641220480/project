package cn.itcast.zjw.springbase.createobject;

/** 
 * @ClassName:SpringPersonFactory
 * @Description:静态工厂创建对象
 * @author TOM
 * @date 2016年5月27日 上午9:45:05
 * @version V1.0.0
 */ 
public class SpringPersonFactory {
	public static SpringPerson initSpringPerson(){
		return new SpringPerson();
	}
}
