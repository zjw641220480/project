package cn.itcast.zjw.socket.socketandthread.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * <p>Title:ServiceServer.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年4月11日下午7:50:26
 */
public class ServiceServer {
	public static void main(String[] args) throws IOException, InterruptedException {
		ServerSocket serverSocket = new ServerSocket(10001);
		ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(3);
		ExecutorService queueService = Executors.newFixedThreadPool(4);
		ExecutorService Service = Executors.newFixedThreadPool(4);
		while(true){
			Socket socket = serverSocket.accept();
			String line = null;
			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			while((line = bufferedReader.readLine())!=null){
				Input input = new ServiceServer().new Input(arrayBlockingQueue, line);
				queueService.submit(input);
				Thread.currentThread().sleep(1000l);
				System.out.println(arrayBlockingQueue);
			}
			socket.close();
		}
	}
	class Input implements Runnable{
		ArrayBlockingQueue<String> arrayBlockingQueue = null;
		String data ;
		public Input(ArrayBlockingQueue arrayBlockingQueue,String data) {
			this.arrayBlockingQueue = arrayBlockingQueue;
			this.data = data;
		}
		public void run() {
			try {
				arrayBlockingQueue.put(data);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}
