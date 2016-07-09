package cn.itcast.zjw.io.readerwriter.buffererreaderwriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Test;

/**
 * @Description <br/>
 *              <p>
 *              使用缓冲区复制java文件
 *              注意:readLine方法返回的时候,只返回回车符之前的数据内容,并不返回回车符;
 *              </p>
 * @author TOM
 * @date 2016年5月18日 下午6:51:28
 */
public class BufferedCopy {
	/**
	 * @Description <code>description</code>
	 * @author TOM
	 */
	@Test
	public void bufferedCopy() {
		BufferedReader bufferedReader = null;
		BufferedWriter bufferedWriter = null;
		try {
			bufferedReader = new BufferedReader(new FileReader("fileWriter.txt"));
			bufferedWriter = new BufferedWriter(new FileWriter("/fileWriter.txt"));
			String readStr = null;
			while ((readStr = bufferedReader.readLine()) != null) {
				bufferedWriter.write(readStr);
				// 这一句话注意
				bufferedWriter.newLine();
				bufferedWriter.flush();
			}
			bufferedReader.close();
			bufferedWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
