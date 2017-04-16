package cn.itcast.zjw.io.serializable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *
 * <p>Title:DesSerializable.java</p>
 * <p>Description:从硬盘中反序列化一个对象</p>
 * @author TOM
 * @date 2017年4月12日下午7:17:15
 */
public class DesSerializable {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("D:\\task"));
		Object obj = inputStream.readObject();
		System.out.println(obj);
		System.out.println("反序列化成功");
	}
}
