package cn.itcast.zjw.socket.tcp.mutual;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpMutualServer {
	public static void main(String[] args) throws Exception{
		ServerSocket serverSocket = new ServerSocket(10000);
		Socket socket = serverSocket.accept();
		String ip = socket.getInetAddress().getHostAddress();
		System.out.println("客户端IP为:\t"+ip);
		InputStream inputStream = socket.getInputStream();
		byte bytes[] = new byte[1024];
		int length = inputStream.read(bytes);
		System.out.println(new String(bytes,0,length));
		//给客户端返回数据
		Thread.sleep(3000);
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write("服务端收到信息".getBytes());
		socket.close();
		serverSocket.close();
	}
}
