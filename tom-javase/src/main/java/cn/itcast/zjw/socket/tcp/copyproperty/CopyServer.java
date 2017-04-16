package cn.itcast.zjw.socket.tcp.copyproperty;

import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class CopyServer {
	public static void main(String[] args) throws Exception{
		ServerSocket serverSocket = new ServerSocket(10000);
		Socket socket = serverSocket.accept();
		BufferedReader bufferedReader = 
				new BufferedReader(new InputStreamReader(socket.getInputStream()));
		PrintWriter printWriter = new PrintWriter(new FileWriter("server.txt"),true);
		String line = null;
		while((line = bufferedReader.readLine())!=null){
			if("over".equals(line)){
				break;
			}
			printWriter.println(line);
		}
		printWriter.flush();
		printWriter.close();
		PrintWriter printWriterSocket = new PrintWriter(socket.getOutputStream(),true);
		printWriterSocket.println("上传成功");
		printWriterSocket.close();
		socket.close();
		serverSocket.close();
	}
}
