package cn.itcast.zjw.design.factory.factorymethod;

import cn.itcast.zjw.design.factory.factorymethod.factoryimpl.BenzCarFactory;
import cn.itcast.zjw.design.factory.factorymethod.factoryimpl.BmwCarFactory;
import cn.itcast.zjw.design.factory.product.Car;

public class Client {
	private static Car benzCar;
	private static Car bmwCar;
	private static AbstractFactory benzcarFactory,bmwcarFactory;
	public static void main(String[] args) {
		 //告诉(工厂) 要奔驰车--(奔驰工厂)
		benzcarFactory=new BenzCarFactory();
		benzCar=benzcarFactory.driveFactory();
        //可以开车了
		benzCar.drive();
        System.out.println("-------------------");
        bmwcarFactory=new BmwCarFactory();
        bmwCar=bmwcarFactory.driveFactory();
        bmwCar.drive();
	}
}
