package cn.itcast.zjw.socket.tcp.base;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerCircle {
	public static void main(String[] args) throws Exception {
		//1:使用ServerSocket来创建服务器接收端
		ServerSocket serverSocket = new ServerSocket(10000);
		//2:获得侦听到的Socket客户端服务
		Socket socket = serverSocket.accept();
		System.out.println("客户端IP:\t" + socket.getInetAddress().getHostAddress());
		while (true) {
			//3:从Socket中获得读取流,从而获取数据
			InputStream inputStream = socket.getInputStream();
			byte[] bytes = new byte[1024];
			int length = inputStream.read(bytes);
			System.out.println(new String(bytes, 0, length));
		}
	}
}
