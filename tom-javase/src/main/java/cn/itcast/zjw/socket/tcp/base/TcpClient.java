package cn.itcast.zjw.socket.tcp.base;

import java.io.OutputStream;
import java.net.Socket;

/**
 * 演示tcp传输,
 * 1,tcp分客户端和服务端,
 * 2,客户端对应的对象是Socket,服务端对应的对象是ServerSocket
 * 3,客户端在对象创建的时候,就可以去连接指定的主机;因为TCP是面向连接的,所以在建立Socket服务的时候,就要有服务端存在,并连接成功,形成通路后,在该通路进行数据的传输;
 * 需求:给输入端发送一个文本数据;
 * 步骤:
 * 1,创建Socket服务,并指定要连接的主机和端口,
 * @ClassName:TcpClient
 * @Description:客户端演示
 * @author Tom
 * @Time:2016年7月30日
 *
 */
public class TcpClient {
	public static void main(String[] args) throws Exception{
		//1:创建客户端的Socket服务,指定目的主机和端口;
		Socket socket = new Socket("127.0.0.1", 10001);
		//2:为了发送数据应该获取socket流中的输出流
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write("Netty是基于Java NIO的网络应用框架.Netty是一个NIO client-server(客户端服务器)框架，使用Netty可以快速开发网络应用，例如服务器和客户端协议。Netty提供了一种新的方式来使开发网络应用程序，这种新的方式使得它很容易使用和有很强的扩展性。Netty的内部实现时很复杂的，但是Netty提供了简单易用的api从网络处理代码中解耦业务逻辑。Netty是完全基于NIO实现的，所以整个Netty都是异步的 网络应用程序通常需要有较高的可扩展性，无论是Netty还是其他的基于Java NIO的框架，都会提供可扩展性的解决方案。Netty中一个关键组成部分是它的异步特性.".getBytes());
		//3:关闭socket资源
		socket.close();
	}
}
