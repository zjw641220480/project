package cn.itcast.zjw.socket.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 服务端
 * 源:socket读取流
 * 目的:socket输出流,
 * 都是文本,使用装饰流
 * 该例子出现的问题,客户端和服务端都在莫名的等待,
 * 因为客户端和服务端都有阻塞式方法,这些方法没有读到结束标记,那么久一直等而导致两端都处于等待状态
 * @ClassName:TcpTransServer
 * @Description:
 * @author Tom
 * @Time:2016年7月31日
 *
 */
public class TcpTransServer {
	
	public static void main(String[] args) throws Exception{
		ServerSocket serverSocket = new ServerSocket(10000);
		//while循环包括监听,使得一直处于监听状态,
		while(true){
			//服务端处于监听状态,
			Socket socket = serverSocket.accept();
			String ip = socket.getInetAddress().getHostAddress();
			System.out.println("连接过来的客户端Ip:\t"+ip);
			//读取Socket流中的数据
			BufferedReader bufferedReader = 
					new BufferedReader(new InputStreamReader(socket.getInputStream()));
			//目的:socket输出流,将大写数据写入到socket输出流,并发送给客户端,
			BufferedWriter bufferedWriter = 
					new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			String line = null;
			while((line = bufferedReader.readLine())!=null){
				System.out.println("服务端获取的数据"+line);
				bufferedWriter.write(line.toUpperCase());
				bufferedWriter.newLine();
				bufferedWriter.flush();
			}
			bufferedReader.close();
			bufferedWriter.close();
			socket.close();
		}
	}
}
