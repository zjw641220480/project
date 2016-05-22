package cn.itcast.zjw.object.ploymorphic;

/** 
* @ClassName: DuoTaiExplain 
* @Description: 多态的解析
* 1,多态的体现
* 	父类的引用指向了自己的子类对象,
* 	父类的引用也可以接收自己的子类对象,
* 2,多态的前提
* 	必须是类与类之间有关系,要么继承,要么实现;
* 	通常还有一个前提:存在覆盖,
* 3,多态的好处
* 	多态的出现大大的提高程序的扩展性
* 4,多态的弊端
* 	虽然提高了程序的扩展性,但是只能使用父类的引用访问父类中的成员;
* 5,多态的应用
* 	见类DuoTaiApply
* 6,多态在代码中的特点
* 		在多态中成员函数(非静态)的特点,编译时期参阅引用型变量所属的类中是否有调用的方法,如果有编译通过,如果没有,编译失败,
* 	但是在运行时期:参阅的是对象所属的类中是否有调用的方法;
* 		简单总结:成员函数在多态调用的时候,编译看左边,运行看右边,
* 		多态中成员变量的特点:无论编译和运行都是参考左边(引用型变量名其所属的类),
* 		多态中静态成员函数的特点:无论编译和运行都是参考左边;
* 	静态绑定和动态绑定
* @author Tom
* @date 2016-2-28 
*/ 
public class DuoTaiExplain{
	public static void main(String[] args) {
		/*Cat cat = new Cat();
		//cat.eat();
		function(cat);
		Dog dog = new Dog();
		//dog.eat();
		function(dog);*/
		Animal animal = new Cat();//向上转型;
		//只能是调用Animal中已经定义的方法,而对于Cat子类中特有的方法是不能进行调用的
		animal.eat();
		function(animal);
		//animal.catchMouse();方法的运行看左边
	}
	public static void function(Animal animal){
		//一方出现类型转换错误,加入逻辑判断
		//Dog dog = (Dog) animal;
		if(animal instanceof Cat){
			Cat cat = (Cat) animal;
			cat.catchMouse();
		} else if(animal instanceof Dog){
			Dog dog = (Dog)animal;
			dog.kanJia();
		} else {
			Pig pig = (Pig)animal;
			pig.gongDi();
		}
	}
	public static void function(Cat cat){
		cat.eat();
	}
	public static void function(Dog dog){
		dog.eat();
	}
	public static void function(Pig pig){
		pig.eat();
	}

}

abstract class Animal {
	public abstract void eat();
}

class Cat extends Animal{

	@Override
	public void eat() {
		System.out.println("Cat.eat()吃鱼");
	}
	public void catchMouse() {
		System.out.println("Cat.catchMouse()抓老鼠");
	}
}

class Dog extends Animal{
	@Override
	public void eat() {
		System.out.println("Dog.eat()吃骨头");
	}
	public void kanJia() {
		System.out.println("Dog.kenBone()看家");
	}
}

class Pig extends Animal{
	@Override
	public void eat() {
		System.out.println("Pig.eat()饲料");
	}
	public void gongDi() {
		System.out.println("Pig.gongDi()拱地");
	}
}
