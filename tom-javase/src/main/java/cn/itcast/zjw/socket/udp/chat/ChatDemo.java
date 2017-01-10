package cn.itcast.zjw.socket.udp.chat;

import java.net.DatagramSocket;

/**
 * 编写聊天程序,由收数据的部分,和发数据的部分,而且这两部分需要同时运行,那就需要用到多线程技术;
 * 一个线程控制收,一个线程控制发;
 * 因为收和发的动作是不一致的,所以,要定义两个run方法,而且这两个方法要封装到不同的类中;
 */
/**
 * 客户端和服务端使用的是不同的DatagramSocket服务;需要创建不同的对象;
 * @ClassName:ChatDemo
 * @Description:
 * @author Tom
 * @Time:2016年7月29日
 *
 */
public class ChatDemo {
	public static void main(String[] args) throws Exception {
		DatagramSocket datagramSocketSend = new DatagramSocket();
		DatagramSocket datagramSocketRece = new DatagramSocket(10000);

		Send send = new Send(datagramSocketSend);
		Rece rece = new Rece(datagramSocketRece);
		Thread threadSend = new Thread(send);
		Thread threadRece = new Thread(rece);
		threadRece.start();
		threadSend.start();
	}
}
