package cn.itcast.zjw.socket.tcp.base;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClientCircle {
	public static void main(String[] args) throws Exception{
		//1:创建客户端的Socket服务,指定目的主机和端口;
		Socket socket = new Socket("127.0.0.1", 10000);
		OutputStream outputStream = socket.getOutputStream();
		while(true){
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			String line = null;
			outputStream.write(line.getBytes());
			bufferedReader.close();
		}
	}
}
