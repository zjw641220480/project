package cn.itcast.zjw.socket.socketandthread.client;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * <p>Title:Client.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年4月11日下午7:54:45
 */
public class Client {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 10000);
		BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		bufferedWriter.write("sssss");
		bufferedWriter.flush();
		bufferedWriter.close();
		socket.close();
	}
}
