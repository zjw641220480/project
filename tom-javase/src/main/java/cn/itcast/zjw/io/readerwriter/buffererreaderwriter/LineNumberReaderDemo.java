package cn.itcast.zjw.io.readerwriter.buffererreaderwriter;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

import org.junit.Test;

/** 
 * @Description <br/>
	<p>带有读取行号的LineNumberReader类</p>
 * @author TOM
 * @date 2016年5月19日 下午4:05:15
 */ 
public class LineNumberReaderDemo {
	@Test
	public void test(){
		FileReader fileReader = null;
		try {
			fileReader = new FileReader("fileWriter.txt");
			LineNumberReader lineNumberReader = new LineNumberReader(fileReader);
			String line = null;
			while((line = lineNumberReader.readLine())!=null){
				System.out.println(lineNumberReader.getLineNumber()+"\t"+line);
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
