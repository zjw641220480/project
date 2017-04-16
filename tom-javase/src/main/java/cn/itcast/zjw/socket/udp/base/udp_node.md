# tom-javase-reflect
java中的UDP
	UDP建立客户端和服务端使用的都是DatagramSocket类,
	发送端使用DatagramPacket(数据报包)来封装数据,并且包括要发送到的服务端的IP地址和端口,数据有大小限制,
	然后使用DatagramSocket的send方法发送到数据报包中指定的服务端;
	UDP服务端将接收到的数据报包放入缓存数组中;
	
	
	
	