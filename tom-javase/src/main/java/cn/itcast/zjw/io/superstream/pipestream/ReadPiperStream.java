package cn.itcast.zjw.io.superstream.pipestream;

import java.io.IOException;
import java.io.PipedInputStream;
/**
 * 
 * @ClassName:ReadPiperStream
 * @Description:使用管道流,读取数据
 * @author Tom
 * @Time:2016年7月25日
 *
 */
public class ReadPiperStream implements Runnable{
	private PipedInputStream inputStream;
	public ReadPiperStream(PipedInputStream inputStream){
		this.inputStream = inputStream;
	}
	public void run() {
		try {
			while(true){
				byte[] bytes = new byte[1024];
				System.out.println("读取前,暂时没有数据,该线程暂时为阻塞状态");
				int length = inputStream.read(bytes);
				System.out.println("读取到数据,阻塞状态结束");
				String s = new String(bytes,0,length);
				System.out.println(s);
			}
		} catch (Exception e) {
		} finally{
			try {
				inputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
}
