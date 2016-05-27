package cn.itcast.zjw.io.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

public class EncodingUtf8 {
	private static EncodingUtf8 encodingUtf8 = new EncodingUtf8();
	private BufferedReader bufferedReader = null;
	private BufferedWriter bufferedWriter = null;
	private static int count=0;
	
	public static int getCount() {
		return count;
	}
	public static void main(String[] args) {
		String path = "D:\\BaiduYunDownload\\hibernate_day01\\src\\cn\\itcast\\hibernate\\test/PersonTest.java";
		File file = new File(path);
		encodingUtf8.updateAllFilesEncoding(file);
	}
	/** 
	 * @MethodName:getAllFiles
	 * @Desription:给定一个目录,更改该目录下文件的编码
	 * @date:2016年5月24日
	 * @author TOM
	 * @param file  
	 */
	public void getAllFiles(File file) {
		File[] files = file.listFiles();
		for (File f : files) {
			if (f.isDirectory()) {
				getAllFiles(f);
			} else if (f.isFile()&&!f.isHidden()) {
				//这里递归
				encodingUtf8.updateAllFilesEncoding(f);
			}
		}
		closeIO(bufferedReader, bufferedWriter);
	}

	/** 
	 * @MethodName:updateAllFilesEncoding
	 * @Desription:取得文件编码,并更改该文件编码(一个文件)
	 * @date:2016年5月24日
	 * @author TOM
	 * @param file  
	 */
	private void updateAllFilesEncoding(File file) {
		String codeEncoding = GetEncoding.codeFile(file);
		if (codeEncoding != "UTF-8") {
			count++;
			// 将此文件改变编码
			encodingUtf8.updateOneFileEncoding(file, codeEncoding);
		}
	}

	/** 
	 * @MethodName:updateOneFileEncoding
	 * @Desription:更改指定文件编码
	 * @date:2016年5月24日
	 * @author TOM
	 * @param file
	 * @param codeEncoding  
	 */
	private void updateOneFileEncoding(File file, String codeEncoding) {
		// 产生UTF-8编码的临时文件
		String originalFileName = file.toString();
		String newFileName = file.toString().substring(0, file.toString().lastIndexOf("\\")) + "linshi" + file.toString().substring(file.toString().indexOf('.'));
		File newLinShiFile = new File(newFileName);
		try {
			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(originalFileName)), codeEncoding));
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(newFileName)), "UTF-8"));
			encodingUtf8.readAndWrite(bufferedReader, bufferedWriter);
			// 删除原有文件
			file.delete();
			bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(newFileName)), "UTF-8"));
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(new File(originalFileName)), "UTF-8"));
			encodingUtf8.readAndWrite(bufferedReader, bufferedWriter);
			newLinShiFile.delete();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @MethodName:readAndWrite
	 * @Desription:读写一个文件
	 * @date:2016年5月24日
	 * @author TOM
	 * @param bufferedReader
	 * @param bufferedWriter
	 * @throws IOException
	 */
	private void readAndWrite(BufferedReader bufferedReader, BufferedWriter bufferedWriter) throws IOException {
		String read = null;
		while ((read = bufferedReader.readLine()) != null) {
			bufferedWriter.write(read);
			bufferedWriter.newLine();
			bufferedWriter.flush();
		}
	}
	/** 
	 * @MethodName:closeIO
	 * @Desription:关闭流的相关方法
	 * @date:2016年5月24日
	 * @author TOM
	 * @param bufferedReader
	 * @param bufferedWriter  
	 */
	private void closeIO(BufferedReader bufferedReader,BufferedWriter bufferedWriter){
		if(bufferedReader!=null){
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(bufferedWriter!=null){
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
