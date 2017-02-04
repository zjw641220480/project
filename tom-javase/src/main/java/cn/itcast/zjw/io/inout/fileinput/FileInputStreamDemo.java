package cn.itcast.zjw.io.inout.fileinput;

import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;

public class FileInputStreamDemo {
	/** 
	 * @Description <code>字节流读取数据,一次读取一个</code>
	 * @author TOM  
	 */
	@Test
	public void testFileOutput(){
		try {
			FileInputStream fileInputStream = new FileInputStream("FileInputStream.txt");
			int read = 0;
			while((read = fileInputStream.read())!=-1){
				System.out.print((char)read);
			}
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/** 
	 * @Description <code>description</code>
	 * @author TOM  
	 */
	@Test
	public void testFileOutputArray(){
		try {
			FileInputStream fileInputStream = new FileInputStream("FileInputStream.txt");
			int read = 0;
			byte[] bytes = new byte[1024];
			while((read = fileInputStream.read(bytes))!=-1){
				System.out.println(new String(bytes,0,read));
			}
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/** 
	 * @Description <code>字节流中特殊的方法available</code>
	 * @author TOM  
	 */
	@Test
	public void testFileOutputAvailable(){
		try {
			FileInputStream fileInputStream = new FileInputStream("FileInputStream.txt");
			int read = fileInputStream.available();
			//定义一个刚刚好的缓冲区,不用循环了,这种方式只能是读取较小的文件;
			byte[] bytes = new byte[read];
			fileInputStream.read(bytes);
			System.out.println(new String(bytes));
			fileInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}	
