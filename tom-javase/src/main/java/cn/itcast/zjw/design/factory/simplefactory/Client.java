package cn.itcast.zjw.design.factory.simplefactory;

import cn.itcast.zjw.design.factory.simplefactory.product.Car;

/**
 * 
 * <p>Titile:Client</p>
 * <p>Description: 使用者</p>
 * @author TOM
 * @date 2017年7月1日 下午5:57:40
 */
public class Client {
	public static void main(String[] args) throws Exception {
		Car car = DriverFactory.dirveCar(CarType.benzCar);
		car.drive();
	}
}
