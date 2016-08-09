package cn.itcast.zjw.socket.tcp.base;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;

public class TcpClientCircle {
	public static void main(String[] args) throws Exception{
		//1:创建客户端的Socket服务,指定目的主机和端口;
		Socket socket = new Socket("127.0.0.1", 10000);
		//2:得到TCP中用来写入数据的流;
		OutputStream outputStream = socket.getOutputStream();
		String line = null;
		while(true){
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
			line = bufferedReader.readLine();
			//3:把数据写入到流中,这里没有使用到缓冲的相关内容,所以可以不用刷新即可;
			outputStream.write(line.getBytes());
		}
	}
}
