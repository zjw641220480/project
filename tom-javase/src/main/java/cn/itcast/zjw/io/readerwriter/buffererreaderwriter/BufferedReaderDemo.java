package cn.itcast.zjw.io.readerwriter.buffererreaderwriter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

/**
 * @Description <br/>
 *              <p>
 *              该缓冲区提供了一个一次读取一行的方法readLine,方便对文本数据的获取,
 *              但是这种方式在打印的时候若不加ln,则直接在一行中输出所有.判断条件是读取到的最后数据不为null
 *              </p>
 * @author TOM
 * @date 2016年5月18日 下午6:44:04
 * @version V1.3.1
 */
public class BufferedReaderDemo {
	/**
	 * @Description <code>字符缓冲区的ReadLine方法</code>
	 * @author TOM
	 */
	@Test
	public void readLine() {
		try {
			// 创建一个读取流和文件相关联
			FileReader fileReader = new FileReader("fileWriter.txt");
			// 为了提高效率加入缓冲技术,将字符读取流对象作为参数传递给缓冲对象的构造函数
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String readStr = null;
			while ((readStr = bufferedReader.readLine()) != null) {
				System.out.println(readStr);
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
