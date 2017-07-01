package cn.itcast.zjw.design.factory.factorymethod.factoryimpl;

import cn.itcast.zjw.design.factory.factorymethod.AbstractFactory;
import cn.itcast.zjw.design.factory.product.BenzCar;
import cn.itcast.zjw.design.factory.product.Car;

public class BenzCarFactory implements AbstractFactory{

	public Car driveFactory() {
		return new BenzCar();
	}

}
