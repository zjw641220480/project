package cn.itcast.zjw.socket.tcp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

/**
 * 需求:建立一个文本转换器,
 * 客户端给服务端发送文本,服务端会将文本转成大写,再返回给客户端,而且客户端可以不断的进行文本转换,当客户端输入over时转换结束;
 * 分析:
 * 客户端,既然是操作设备上的数据,那么就可以使用IO技术,并按照io的操作规律来思考,
 * 源:键盘录入
 * 目的:网络设备,网络输出流;
 * 而且操作的是文本数据,可以选择字符流;
 * 步骤:
 * 1:建立服务,
 * 2:获取键盘录入,
 * 3:将数据发给服务端,
 * 4:获取服务端返回的大写数据,
 * 5:结束,关闭资源;
 * 都是文本数据,可以使用字符流进行操作,同时,为了提高效率,可以加入缓冲;
 * @ClassName:TcpDemo
 * @Description:
 * @author Tom
 * @Time:2016年7月31日
 *
 */
public class TcpTransClient {
	public static void main(String[] args) throws Exception{
		//建立客户端Socket服务
		Socket socket = new Socket("127.0.0.1", 10000);
		//定义读取键盘数据的流对象
		BufferedReader bufferedReader = 
				new BufferedReader(new InputStreamReader(System.in));
		//定义目的,将数据写入到socket输出流,发给服务端,
		BufferedWriter bufferedWriter = 
				new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		//定义一个Socket读取流,读取服务端返回的大写信息;
		BufferedReader bufferedReaderSocket = 
				new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String line =  null;
		//while中的是读取键盘录入
		while((line = bufferedReader.readLine())!=null){
			System.out.println("获取键盘录入"+line);
			if(line.equals("over")){
				return;
			}
			bufferedWriter.write(line);
			bufferedWriter.newLine();
			//流中数据刷新
			bufferedWriter.flush();
			//这一个读取时读取服务端返回的数据;
			String strServer = bufferedReaderSocket.readLine();
			System.out.println("服务端返回的数据:\t"+strServer);
		}
		bufferedReader.close();
		socket.close();
	}
}






