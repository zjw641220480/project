package cn.itcast.zjw.design.factory.factorymethod;

import cn.itcast.zjw.design.factory.product.Car;
/**
 * 
 * <p>Titile:AbstractFactory</p>
 * <p>Description:抽象工厂类 </p>
 * @author TOM
 * @date 2017年7月1日 下午6:12:33
 */
public interface AbstractFactory {
	public Car driveFactory();
}
