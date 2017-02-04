package cn.itcast.zjw.io.readerwriter.filereaderwriter.filewriter;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @Description <br/>
 *              <p>
 *              IO流按操作数据分为两种:字节流和字符流;
 *              字节流的两个基类:InputStream	OutputStream
 *              字符流的两个基类:Reader 		Writer
 *              按流向分为:输入流,输出流;
 *              先以操作文件为主来作为演示
 *              需求:在硬盘上创建一个文件并写入一些文字数据,
 *              </p>
 * @author TOM
 * @date 2016年5月18日 下午3:59:56
 * @version V1.3.1
 */
public class FileWriterDemo {
	public static void main(String[] args) {
		//创建一个FileWriter对象,该对象一杯初始化,就必须要明确所操作的文件
		//而且该文件会被创建到指定的目录下,如果该目录下已有同名文件,将覆盖之前的文件
		//当文件名是绝对路径名的时候那么,直接是创建到根目录下
		try {
			//其实该不走就是明确数据要存放的目的地
			FileWriter fileWriter = new FileWriter("fileWriter.txt");
			//调用write方法,将字符串写入到流中
			fileWriter.write("123");
			//刷新流对象缓存中的数据,将数据刷到目的地
			fileWriter.flush();
			//关闭流资源,但是关闭之前会刷新一次流内部中的数据,和flush的区别:flush刷新后,流可以继续使用,close刷新后,会将流关闭
			fileWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
