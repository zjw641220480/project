package cn.itcast.zjw.socket.tcp.base;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerCircle {
	public static void main(String[] args) throws Exception{
		ServerSocket serverSocket = new ServerSocket(10000);
		while(true){
			Socket socket = serverSocket.accept();
			System.out.println("客户端IP:\t"+socket.getInetAddress().getHostAddress());
			InputStream inputStream = socket.getInputStream();
			byte[] bytes = new byte[1024];
			int length = inputStream.read(bytes);
			while(true){
				System.out.println(new String(bytes,0,length));
			}
		}
	}
}
