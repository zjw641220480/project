package cn.itcast.zjw.io.readerwriter.buffererreaderwriter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/**
 * @Description <br/>
 *              <p>
 *              缓冲区的出现时为了提高流的操作效率而出现的 所以在创建缓冲区之前,必须要先有流对象
 *              </p>
 * @author TOM
 * @date 2016年5月18日 下午6:34:53
 * @version V1.3.1
 */
public class BufferedWriterDemo {
	@Test
	public void buffer(){
		try {
			//创建一个字符写入流对象
			FileWriter fileWriter = new FileWriter("");
			//为了提高字符写入流效率,加入了缓冲继续,只要将需要被提高效率的对象作为参数传递给缓冲区的构造函数即可
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			bufferedWriter.write("bufferedWritter");
			//bufferedWriter.newLine();换行
			bufferedWriter.flush();
			//缓冲区的关闭就是在关闭缓冲区中的流对象;
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
