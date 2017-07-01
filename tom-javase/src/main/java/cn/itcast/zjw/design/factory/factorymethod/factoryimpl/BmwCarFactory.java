package cn.itcast.zjw.design.factory.factorymethod.factoryimpl;

import cn.itcast.zjw.design.factory.factorymethod.AbstractFactory;
import cn.itcast.zjw.design.factory.product.BmwCar;
import cn.itcast.zjw.design.factory.product.Car;

public class BmwCarFactory implements AbstractFactory{

	public Car driveFactory() {
		return new BmwCar();
	}
	
}
