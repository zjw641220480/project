package cn.itcast.zjw.io.readerwriter.filereaderwriter.filereader;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/**
 * @Description <br/>
 *              <p>
 *              将C盘一个文件复制到D盘
 *              步骤:
 *              1:在D盘创建一个文件,用于存储C盘文件中的数据;
 *              2:定义读取流和C盘文件关联,
 *              3:通过不断的读写文成数据存储
 *              4:关闭流
 *              </p>
 * @author TOM
 * @date 2016年5月18日 下午6:08:05
 * @version V1.3.1
 */
public class FileCopy {
	/** 
	 * @Description <code>每读取一个字符就往D盘写一个字符</code>
	 * @author TOM  
	 */
	@Test
	public void copy1(){
		try {
			//创建目的地
			FileWriter fileWriter = new FileWriter("/fileWriter.txt");
			//已有文件 
			FileReader fileReader = new FileReader("fileWriter.txt");
			int ch = 0;
			while((ch = fileReader.read())!=-1){
				fileWriter.write(ch);
				fileWriter.flush();
			}
			fileWriter.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/** 
	 * @Description <code>一次读取一个chars数组</code>
	 * @author TOM  
	 */
	@Test
	public void copu2(){
		try {
			//创建目的地
			FileWriter fileWriter = new FileWriter("/fileWriter.txt");
			//已有文件
			FileReader fileReader = new FileReader("fileWriter.txt");
			char[] chars = new char[1024];
			int reader = 0;
			while((reader=fileReader.read(chars))!=-1){
				fileWriter.write(chars, 0, reader);
				fileWriter.flush();
			}
			fileWriter.close();
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
