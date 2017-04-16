package cn.itcast.zjw.socket.tcp.base;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 
 * @ClassName:TcpServerCircle
 * @Description:循环读取的服务端
 * @Time:2017年4月10日
 * @author:Tom
 */
public class TcpServerCircle {
	public static void main(String[] args) throws Exception {
		//1:使用ServerSocket来创建服务器接收端
		ServerSocket serverSocket = new ServerSocket(10000);
		//2:获得侦听到的Socket客户端服务
		Socket socket = serverSocket.accept();
		System.out.println("客户端IP:\t" + socket.getInetAddress().getHostAddress());
		while (true) {
			try {
				//3:从Socket中获得读取流,从而获取数据
				InputStream inputStream = socket.getInputStream();
				byte[] bytes = new byte[1024];
				int length = inputStream.read(bytes);
				System.out.println(new String(bytes, 0, length));
			} catch (Exception e) {
				//客户端断开连接后,避免服务端报错,而导致进程终止,故重新启动监听;
				socket = serverSocket.accept();
				System.out.println(e.getMessage());
			}
		}
	}
}
