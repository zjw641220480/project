package cn.itcast.zjw.design.factory.simplefactory;

import cn.itcast.zjw.design.factory.product.BenzCar;
import cn.itcast.zjw.design.factory.product.BmwCar;
import cn.itcast.zjw.design.factory.product.Car;

/**
 * 
 * <p>Titile:DriverFactory</p>
 * <p>Description:工厂类角色,此工厂根据传递参数,返回对应的javabean </p>
 * @author TOM
 * @date 2017年7月1日 下午5:55:14
 */
public class DriverFactory {
	 //返回类型必须为抽象产品角色
    public static Car dirveCar(CarType params) throws          Exception{
        //判断逻辑，返回具体的产品角色给Client
        if(params.equals(CarType.benzCar)){
            return new BenzCar();
        }else if(params.equals(CarType.bmwCar)){
            return new BmwCar();
        }else{
            throw new Exception(); 
        }   
    }
}
