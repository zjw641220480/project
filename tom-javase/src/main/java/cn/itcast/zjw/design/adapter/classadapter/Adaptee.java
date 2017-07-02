package cn.itcast.zjw.design.adapter.classadapter;

/**
 * 
 * <p>Titile:Adaptee</p>
 * <p>Description: 已存在的、具有特殊功能、但不符合我们既有的标准接口的类 </p>
 * @author TOM
 * @date 2017年7月1日 下午9:12:57
 */
public class Adaptee {
	public void specificRequest() {
        System.out.println("被适配类...我是两孔插座  具有特殊功能");
    }
}
