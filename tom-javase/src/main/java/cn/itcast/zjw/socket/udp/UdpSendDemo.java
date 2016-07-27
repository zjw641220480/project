package cn.itcast.zjw.socket.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * 通过udp传输方式,将一段文字数据发送出去;
 * 1:建立UDP的Socket服务;
 * 2:提供数据,并将数据封装到数据包中;
 * 3:通过Scoket服务的发送功能,将数据包发送出去;
 * 4:关闭资源
 */
/**
 * 
 * @ClassName:UdpSendDemo
 * @Description:
 * @author Tom
 * @Time:2016年7月26日
 *
 */
public class UdpSendDemo {
	public static void main(String[] args) throws IOException {
		int flag = 0;
		//1:创建UDP服务,通过DatagramSocket,指定从哪一个端口发送出去,同一台
		DatagramSocket datagramSocket = new DatagramSocket(10000);
		while(flag<100){
			//2:提供数据,并将数据封装
			//DatagramPacket(byte[] buf, int length, InetAddress address, int port) 
			//数据,ip地址,端口号
			byte[] bytes = ("这个是数据\t"+flag).getBytes();
			InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
			DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length,inetAddress,8888);
			//3:通过Socket服务,将已有的数据包发送出去,通过send方法;
			datagramSocket.send(datagramPacket);
			flag++;
		}
		//4:关闭资源
		datagramSocket.close();
	}
}
