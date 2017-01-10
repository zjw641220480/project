package cn.itcast.zjw.socket.udp.base;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 定义一个应用程序,用于接收udp协议传输的数据并处理
 * 1:定义Udp的Socket服务,必须指定一个监听端口,给这个接收网络应用程序定义数字标识;
 * 	方便于明确那些数据过来后,该应用程序可以进行解析;
 * 2:定义一个用来存储接收到的字节数据的数据包
 *	因为数据包对象中有更多功能可以提取字节数据中的不同数据信息;
 * 3:通过Socket服务的receive方法将接收到的数据存入已经定义好的数据包中;
 * 4:通过数据包对象的特有功能,将这些不同的数据取出;打印在控制台,
 */
/**
 * 
 * @ClassName:UdpReceiveDemo
 * @Description:
 * @author Tom
 * @Time:2016年7月27日
 *
 */
public class UdpReceiveDemo {
	public static void main(String[] args) throws IOException {
		//1:创建UDP的Socket服务,建立端点;*******指定监听端口
		DatagramSocket datagramSocket = new DatagramSocket(8888);
		try{
			while(true){
				//2:定义数据包用于存储数据
				byte[] bytes = new byte[1024];
				DatagramPacket datagramPacket = new DatagramPacket(bytes, bytes.length);
				//3:通过服务的receive方法将收到的数据存入数据包中
				datagramSocket.receive(datagramPacket);
				//4:通过数据包的方法获取数据
				System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));
				//5:关闭资源
			}
		} finally{
			datagramSocket.close();
			System.out.println("接收端Socket服务关闭");
		}
	}
}
