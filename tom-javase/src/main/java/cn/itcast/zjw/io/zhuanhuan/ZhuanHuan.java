package cn.itcast.zjw.io.zhuanhuan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Properties;

import org.junit.Test;


/**
 *  转换流的使用:转换流的一个重要作用就是编码的改变 InputStreamReader:
 *  	字节流转换为字符流的桥梁OutputStreamWriter,InputStreamReader;
 */
/** 
 * @ClassName: ZhuanHuan
 * @Description:
 * @Time 2016年6月1日 下午9:04:32
 * @author: TOM
 * @version 1.0.0
 * @since  1.6
 */
public class ZhuanHuan {
	/**
	 * @Description <code>键盘录入</code>
	 * @author TOM
	 * @throws IOException
	 */
	@Test
	public void in() throws IOException {
		InputStream in = System.in;
		StringBuilder builder = new StringBuilder();

		while (true) {
			int ch = in.read();
			if (ch == '\r') {
				continue;
			} else if (ch == '\n') {
				String s = builder.toString();
				if ("over".equals(s)) {
					break;
				}
				System.out.println(s.toUpperCase());
				builder.delete(0, builder.length());
			} else {
				builder.append((char) ch);
			}
		}
	}

	/**
	 * @Description <code>转换流的使用实例</code>
	 * @author TOM
	 * @throws IOException
	 */
	@Test
	public void inZhuanhuan() throws IOException {
		// 获取键盘录入对象
		InputStream inputStream = System.in;
		// 将字节流对象转换为字符流对象,使用转换流InputStreamReader
		InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
		// 为了提高效率,将字符串进行缓冲区技术的高效操作使用BufferedReader;
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
		String str = null;
		while ((str = bufferedReader.readLine()) != null) {
			if ("over".equals(str)) {
				break;
			}
			System.out.println(str);
		}
		bufferedReader.close();
	}

	/** 
	 * @Description <code>控制台的输入输出(输入输出均使用转换流)</code>
	 * @author TOM
	 * @throws IOException  
	 */
	@Test
	public void outZhuanhuan() throws IOException {
		// 这句话就是键盘录入
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		// 输出
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
		String str = null;
		while ((str = bufferedReader.readLine()) != null) {
			if ("over".equals(str)) {
				break;
			} else {
				bufferedWriter.write(str);
				bufferedWriter.newLine();
				bufferedWriter.flush();
				System.out.println(str);
			}
		}
		bufferedReader.close();
		bufferedWriter.close();
	}

	/** 
	 * @Description <code>写入文本时候指定编码</code>
	 * @author TOM
	 * @throws IOException  
	 */
	@Test
	public void testCahrset() throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("charset.txt")));
		String str = null;
		while ((str = bufferedReader.readLine()) != null) {
			if ("over".equals(str)) {
				break;
			} else {
				bufferedWriter.write(str);
				bufferedWriter.newLine();
				bufferedWriter.flush();
				System.out.println(str);
			}
		}
		bufferedReader.close();
		bufferedWriter.close();
	}
	@Test
	public void run(){
		Properties properties = System.getProperties();
		properties.list(System.out);
	}
}
