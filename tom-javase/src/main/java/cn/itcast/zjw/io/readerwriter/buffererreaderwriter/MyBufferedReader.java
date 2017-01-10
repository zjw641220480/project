package cn.itcast.zjw.io.readerwriter.buffererreaderwriter;

import java.io.FileReader;
import java.io.IOException;

/**
 * @Description <br/>
 *              <p>
 *              明白了BufferedReader类中特有方法readLine的原理后
 *              可以自定义一个类中包换一个功能和readLine一致的方法来模拟BufferedReader
 *              </p>
 * @author TOM
 * @date 2016年5月19日 下午2:32:38
 */
public class MyBufferedReader {
	private static FileReader fileReader;
	@SuppressWarnings("static-access")
	public MyBufferedReader(FileReader fileReader) {
		this.fileReader = fileReader;
	}
	/** 
	 * @Description <code>自己定义的一次读取一行数据的方法</code>
	 * @author TOM  
	 */
	public static String myReadLine() {
		//定义一个临时容器;原BufferedReader封装的是字符数组
		StringBuffer buffer = new StringBuffer();
		int ch = 0;
		try {
			while((ch = fileReader.read())!=-1){
				if(ch =='\r'){
					continue;
				}
				else if(ch == '\n'){
					return buffer.toString();
				}
				else{
					buffer.append((char)ch);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/** 
	 * @Description <code>袭击定义的一个关闭方法</code>
	 * @author TOM  
	 */
	public static void myClose(){
		if(fileReader!=null){
			try {
				
				fileReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
