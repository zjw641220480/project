package cn.itcast.zjw.io.superstream.pipestream;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 
 * @ClassName:PipedStream
 * @Description:使用管道流对数据进行读写
 * @author Tom
 * @Time:2016年7月25日
 *
 */
public class PipedStream {
	/**
	 * 
	 * @Method:testPipedStream
	 * @Description:
	 * @author Tom
	 * @throws IOException 
	 * @date 2016年7月25日 下午11:08:57
	 */
	public static void main(String[] args) throws IOException {
		PipedOutputStream outputStream = new PipedOutputStream();
		PipedInputStream inputStream = new PipedInputStream();
		//管道流对接方法
		inputStream.connect(outputStream);
		ReadPiperStream readPiperStream = new ReadPiperStream(inputStream);
		WritePipedStream writePipedStream = new WritePipedStream(outputStream, 1);
		Thread threadA = new Thread(readPiperStream);
		Thread threadB = new Thread(writePipedStream);
		threadA.start();
		threadB.start();
	}
}
