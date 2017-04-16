package cn.itcast.zjw.io.serializable;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import cn.itcast.zjw.domain.Person;

/**
 *
 * <p>Title:SerSerializable.java</p>
 * <p>Description:序列化一个对象到硬盘</p>
 * @author TOM
 * @date 2017年4月12日下午7:14:15
 */
public class SerSerializable {
	public static void main(String[] args) throws FileNotFoundException, IOException {
		Person person = new Person();
		person.setAge(30);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:\\task"));
		objectOutputStream.writeObject(person);
		objectOutputStream.flush();
		objectOutputStream.close();
		System.out.println("序列化成功");
	}
}
