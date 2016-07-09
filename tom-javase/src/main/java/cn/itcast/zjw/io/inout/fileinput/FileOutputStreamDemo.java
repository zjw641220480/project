package cn.itcast.zjw.io.inout.fileinput;

import java.io.FileOutputStream;
import java.io.IOException;

import org.junit.Test;

/** 
 * @ClassName: FileInputStreamDemo
 * @Description:
 * @Time 2016年6月1日 下午8:58:44
 * @author: TOM
 * @version 1.0.0
 * @since  1.6
 */
public class FileOutputStreamDemo {
	
	/** 
	 * @Description <code>字节流写入数据,不需要刷新,即可写入到文本中</code>
	 * @author TOM  
	 */
	@Test
	public void testFileInput(){
		try {
			FileOutputStream fileOutputStream = new FileOutputStream("FileInputStream.txt");
			fileOutputStream.write("abcde".getBytes());
			//fileOutputStream.flush();
			fileOutputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
