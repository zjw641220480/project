package cn.itcast.zjw.socket.tcp.mutual;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * 演示TCP的传输中的客户端和服务端的互访;
 * 需求:客户端给服务端发送数据,服务端收到后,给客户端反馈信息;
 * 客户端
 * 1:建立Socket服务,指定要连接主机和端口;
 * 2:获取Socket流中的输出流,将数据写到该流中,通过网络发送给服务端;
 * 3:获取Socket流中的输入流,将服务端反馈的数据获取到,并打印,
 * 4:关闭客户端资源
 * @ClassName:TcpMutualClient
 * @Description:客户端和服务端之间的交互
 * @author Tom
 * @Time:2016年7月31日
 *
 */
public class TcpMutualClient {
	public static void main(String[] args) throws Exception{
		Socket socket = new Socket("127.0.0.1", 10000);
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write("服务端你好".getBytes());
		//从Socket中获取服务端返回的数据,
		InputStream inputStream = socket.getInputStream();
		byte bytes[] = new byte[1024];
		int length = inputStream.read(bytes);
		System.out.println(new String(bytes,0,length));
		socket.close();
	}
}
