package cn.itcast.zjw.socket;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPDemo {
	public static void main(String[] args) throws UnknownHostException {
		InetAddress address = InetAddress.getLocalHost();
		System.out.println(address);
		System.out.println(address.getHostName());//主机名
		System.out.println(address.getAddress());
		System.out.println(address.getHostAddress());//ip地址
//		InetAddress address = InetAddress.getByName("www.baidu.com");
//		System.out.println(address.getHostAddress());
	}
}
