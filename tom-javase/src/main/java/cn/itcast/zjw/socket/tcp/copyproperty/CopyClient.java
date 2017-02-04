package cn.itcast.zjw.socket.tcp.copyproperty;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CopyClient {
	public static void main(String[] args) throws Exception {
		Socket socket = new Socket("127.0.0.1", 10000);
		BufferedReader bufferedReader = 
				new BufferedReader((new FileReader(new File("client.txt"))));
		PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
		long time = System.currentTimeMillis();
		printWriter.println(time);
		String line = null;
		while((line = bufferedReader.readLine())!=null){
			printWriter.println(line);
		}
		// 客户端读取完毕后需要有一个标识来说明其已经读取完毕;
		printWriter.println("over");
		// 关闭客户端的输出流,相当于给流中加入一个结束标记-1;
		socket.shutdownOutput();
		BufferedReader bufferedReaderSocket = 
				new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String lineSocket = bufferedReaderSocket.readLine();
		System.out.println(lineSocket);
		bufferedReader.close();
		socket.close();
	}
}
