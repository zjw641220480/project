package cn.itcast.zjw.socket.udp.chat;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
/**
 * 简单聊天程序的接收端;
 * @ClassName:Rece
 * @Description:
 * @author Tom
 * @Time:2016年8月6日
 *
 */
public class Rece implements Runnable{
	private DatagramSocket socket;
	public Rece(DatagramSocket socket){
		this.socket = socket;
	}
	public void run() {
		try {
			while(true){
				byte[] bytes = new byte[1024];
				DatagramPacket datagramPacket = new DatagramPacket(bytes,bytes.length);
				socket.receive(datagramPacket);
				String ip = datagramPacket.getAddress().getHostAddress();
				String data = new String(datagramPacket.getData(),0,datagramPacket.getLength());
				System.out.println(ip+":\t"+data);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
