package cn.itcast.zjw.io.readerwriter.filereaderwriter.filewriter;

import java.io.FileWriter;
import java.io.IOException;

/** 
 * @Description <br/>
	<p>IO异常处理方式</p>
 * @author TOM
 * @date 2016年5月18日 下午4:27:49
 * @version V1.3.1
 */ 
public class FileWriterException {
	public static void main(String[] args) {
		FileWriter fileWriter = null;
		try {
			fileWriter = new FileWriter("fileWriter.txt");
			fileWriter.write("IO异常处理方式");
			fileWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally{
			if(fileWriter!=null){
				try {
					fileWriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
