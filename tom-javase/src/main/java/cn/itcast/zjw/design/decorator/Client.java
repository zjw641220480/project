package cn.itcast.zjw.design.decorator;

import cn.itcast.zjw.design.decorator.derector.Derector;
import cn.itcast.zjw.design.decorator.derector.Hacker;
import cn.itcast.zjw.design.decorator.derector.SoftwareArchitect;
import cn.itcast.zjw.design.decorator.target.TangGao;

public class Client {
	public static void main(String[] args) {
		// 将要被装饰的对象,初始只有编程的能力
		Programmer programmer = new TangGao();
		programmer.programme();

		// 开始装饰,装饰者也实现了超类接口Programmer
		Derector hacker = new Hacker(programmer);
		System.out.println("第一次装饰");
		hacker.programme();

		Derector achitect = new SoftwareArchitect(hacker);
		System.out.println("第二次装饰");
		achitect.programme();
	}
}
