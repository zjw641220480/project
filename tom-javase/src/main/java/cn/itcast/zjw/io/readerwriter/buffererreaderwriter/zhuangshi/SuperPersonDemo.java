package cn.itcast.zjw.io.readerwriter.buffererreaderwriter.zhuangshi;

/**
 * @Description <br/>
 *              <p>
 *              装饰者模式
 *              继承体系时候的结构:
 *              MyReader
 *              	|--MyTextReader
 *              		|--MyBufferedTextReader
 *              	|--MyMediaReader
 *              		|--MyBufferedMediaReader
 *              	|--MyDataReader
 *              		|--MybufferedDataReader
 *              装饰者模式下的结构
 *              MyReader
 *              	|--MyTextReader
 *              	|--MyMediaReader
 *              	|--MyDataReader
 *              	|--MyBufferedReader
 *              装饰者模式比继承模式更加灵活,避免了继承体系所造成的臃肿,而且降低了类与类之间的关系;
 *              装饰类因为增强已有对象,具备的功能和已有的是相同的,只不过提供了更强的功能;所以装饰类和被装饰类通常是都属于一个体系中的;
 *              </p>
 * @author TOM
 * @date 2016年5月19日 下午3:34:33
 */
public class SuperPersonDemo {
	private PersonDemo personDemo;

	public SuperPersonDemo(PersonDemo personDemo) {
		this.personDemo = personDemo;
	}

	/**
	 * @Description <code>在原有的人吃饭方法上的增强(装饰)</code>
	 * @author TOM
	 */
	// 这里会有一个问题,就是SuperPersonDemo直接继承PersonDemo,然后重写吃饭方法即可,这样不是更方便么??
	public void superChifan() {
		System.out.println("开胃酒");
		personDemo.chifan();
		System.out.println("吃甜点");
	}
}
