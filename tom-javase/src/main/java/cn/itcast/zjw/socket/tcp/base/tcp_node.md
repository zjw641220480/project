# tom-javase-reflect
java中的TCP
	客户端和服务端之间使用Socket进行通讯,Socket中有网络通讯的输入\输出流,服务端多了一个ServerSocket的监听服务
	TcpClient:简单的TCP客户端
	TcpServer:简单的TCP服务端
	ServerSocket serverSocket = new ServerSocket(10000);
	TCP服务端使用ServerSocket监听一个端口,当客户端连接上之后,从InputStream中读取客户端发送来的数据
	
	TcpServerCircle:循环读取的服务端
	TcpClientCircle:循环写入的客户端
	客户端的写入流,和服务端的读取流
	
	
	
	