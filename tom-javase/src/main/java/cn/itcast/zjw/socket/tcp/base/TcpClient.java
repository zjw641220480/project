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
		Socket socket = new Socket("127.0.0.1", 10000);
		//2:为了发送数据应该获取socket流中的输出流
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write("Tcp哥们来了".getBytes());
		//3:关闭socket资源
		socket.close();
	}
}
