package cn.itcast.zjw.io.readerwriter.filereaderwriter.filereader;

import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

/**
 * @Description <br/>
 *              <p>
 *              读取文本数据
 *              </p>
 * @author TOM
 * @date 2016年5月18日 下午6:03:04
 * @version V1.3.1
 */
public class FileReaderDemo {
	/**
	 * @Description <code>不使用数组,一次只读取一个字符方式</code>
	 * @author TOM
	 */
	@Test
	public void read() {
		FileReader fileReader = null;
		try {
			// 创建一个文件读取流对象,和指定名称的文件相关联,
			// 要保证该文件是已经存在的,如果不存在,会发生异常,FileNotException
			fileReader = new FileReader("fileWriter.txt");
			// 调用读取流的相关方法
			int ch = 0;
			while ((ch = fileReader.read()) != -1) {
				System.out.print((char) ch);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fileReader != null) {
				try {
					fileReader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	/** 
	 * @Description <code>一次读取一个char数组的方式</code>
	 * @author TOM  
	 */
	@Test
	public void readChars() {
		FileReader fileReader = null;
		try { 
			fileReader = new FileReader("fileWriter.txt");
			char[] chars = new char[1024];
			int num = 0;
			while ((num = fileReader.read(chars)) != -1) {
				System.out.println(new String(chars, 0, num));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
