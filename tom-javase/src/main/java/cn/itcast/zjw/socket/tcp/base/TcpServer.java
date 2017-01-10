package cn.itcast.zjw.socket.tcp.base;

import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 需求:定义端点接收数据并打印在控制台上,
 * 服务端:
 * 1:建立服务端的socket服务,通过ServerSocket来建立,并监听一个端口,
 * 2:获取连接过来的客户端对象,通过ServerSocket的accept方法,这个方法是阻塞式的,
 * 3:客户端如果发来数据,那么服务端都要使用对应的客户端对象,并获取到该客户端对象的读取流,来读取发过来的数据,并打印在控制台
 * @ClassName:TcpServer
 * @Description:
 * @author Tom
 * @Time:2016年7月31日
 *
 */
public class TcpServer {
	public static void main(String[] args) throws Exception{
		//1:建立服务端的socket服务,并监听一个端口,
		ServerSocket serverSocket = new ServerSocket(10000);
		//2:侦听客户端Socket连接;
		Socket socket = serverSocket.accept();
		String ip = socket.getInetAddress().getHostAddress();
		System.out.println("连接过来的客户端IP为\t"+ip);
		//3:获取客户端发送过来的数据,服务端使用客户端对象的读取流来读取数据;
		InputStream inputStream = socket.getInputStream();
		byte bytes[] = new byte[1024];
		inputStream.read(bytes);
		System.out.println(new String(bytes,0,bytes.length));
		socket.close();
		
	}
}
