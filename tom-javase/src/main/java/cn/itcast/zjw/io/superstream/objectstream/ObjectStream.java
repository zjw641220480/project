package cn.itcast.zjw.io.superstream.objectstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

/**
 * 
 * @ClassName:MyObjectOutputStream
 * @Description:演示使用ObjectStream来序列化对象,注意:静态成员是不能被序列化的;
 * @author Tom
 * @Time:2016年7月25日
 *
 */
public class ObjectStream {
	/**
	 * 
	 * @Method:testObjectOutputSteam
	 * @Description:把一个对象使用流写入到磁盘文件中
	 * @author Tom
	 * @date 2016年7月25日 下午10:15:38
	 * @throws Exception
	 */
	@Test
	public void testObjectOutputStream() throws Exception {
		ObjectOutputStream objectOutputStream = 
				//这种相对路径名方式的文件,其相对的是项目所在目录,
				//也就是说,使用java.io包中的流进行读写的时候,相对路径是相对于项目路径而言的;
				new ObjectOutputStream(new FileOutputStream(new File("obj.txt")));
		Person personA = new Person("lisi",12);
		Person personB = new Person("zhangsan",23);
		System.out.println(personA);
		objectOutputStream.writeObject(personA);
		objectOutputStream.writeObject(personB);
		objectOutputStream.close();
	}
	/**
	 * 
	 * @Method:testObjectInputStream
	 * @Description:把一个写入到磁盘文件的对象流重新的读取出来,两次在内存中的肯定不再是同一个对象,只是属性值一样
	 * @author Tom
	 * @date 2016年7月25日 下午10:28:20
	 * @throws Exception
	 */
	@Test
	public void testObjectInputStream() throws Exception{
		ObjectInputStream objectInputStream = 
				new ObjectInputStream(new FileInputStream(new File("obj.txt")));
		Person personA = (Person) objectInputStream.readObject();
		System.out.println(personA);
		System.out.println(personA.getName());
		Person personB = (Person) objectInputStream.readObject();
		System.out.println(personB.getName());
		objectInputStream.close();
		
	}
}
