package cn.itcast.zjw.io.superstream.pipestream;

import java.io.IOException;
import java.io.PipedOutputStream;
/**
 * 
 * @ClassName:WritePipedStream
 * @Description:使用管道流,写入数据
 * @author Tom
 * @Time:2016年7月25日
 *
 */
public class WritePipedStream implements Runnable{
	private int count;
	private PipedOutputStream outputStream;
	public WritePipedStream(PipedOutputStream outputStream,int count){
		this.outputStream = outputStream;
		this.count = count;
	}
	public void run() {
		try {
			while(true){
				System.out.println("开始写入数据,等待6秒");
				Thread.sleep(6000);
				outputStream.write(("guan dao lai le\t"+count).getBytes());
				System.out.println("写入数据完成");
				count++;
			}
		} catch (Exception e) {
		} finally{
			try {
				outputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
