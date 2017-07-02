package cn.itcast.zjw.design.adapter.classadapter;

/**
 * 
 * <p>Titile:Adapter</p>
 * <p>Description: 适配器类,继承了被适配类，同时实现标准接口</p>
 * @author TOM
 * @date 2017年7月1日 下午9:13:29
 */
public class Adapter extends Adaptee implements Target{

	public void request() {
		System.out.println("我是适配器类 我能适配任何两孔插座 让它正常工作");
        this.specificRequest();
	}
}
