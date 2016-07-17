package cn.itcast.zjw.genericity;

import org.junit.Test;

public interface GenericityInterface<T> {
	public void show(T t);
}
class GenrricityInterfaceDemo implements GenericityInterface<String>{
	@Test
	public void testrun() {
		GenericityInterface<String> genericityInterface = new GenrricityInterfaceDemo();
		genericityInterface.show("s");
	}

	public void show(String t) {
		System.out.println("GenrricityInterfaceDemo.show()\t"+t);
	}

}