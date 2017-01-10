package cn.itcast.zjw.socket.udp.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/**
 * 简单聊天程序的发送端
 * @ClassName:Send
 * @Description:
 * @author Tom
 * @Time:2016年8月6日
 *
 */
public class Send implements Runnable {
	private DatagramSocket socket;

	public Send(DatagramSocket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			while ((line = bufferedReader.readLine()) != null) {
				if(line.equals("886")){
					return;
				}
				DatagramPacket datagramPacket = new DatagramPacket(line.getBytes(), line.getBytes().length,
						InetAddress.getByName("127.0.0.1"), 10000);
				socket.send(datagramPacket);
				
			}
		} catch (Exception e) {
		}
	}

}
