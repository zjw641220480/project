/**
 * @Project: tom-javase @(#) CopyJavaPath.java
 * 
 * Copyright (c) 2016, Credan-版权所有
 * 
 */
package cn.itcast.zjw.io.file.exercise;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.List;

import org.junit.Test;
import org.tom.util.logger.LoggerTypeEnum;
import org.tom.util.logger.LoggerUtil;

/**
 * 当把文件地址加入到流的时候若文件不存在就会创建该文件
 * 练习:将一个指定目录下的java文件的绝对路径,存储到一个文本文件中去;建立一个java文件列表文件
 * 思路:
 * 1:对指定目录进行递归,
 * 2:获取递归过程中所有java文件的路径
 * 3:将这些路径存储到集合中;
 * 4:将集合中的数据写入到一个文件中
 * */
/**
 * @ClassName: CopyJavaPath
 * @Description:将目录中的所有java文件绝对路径名输入到一个文本文件中
 * @Time 2016年5月21日 下午3:05:05
 * @author: TOM
 * @version 1.0.0
 * @since 1.6
 */
public class CopyJavaPath {
	BufferedWriter bufferedWriter = null;
	//用于记录找到多少指定文件
	int count = 0;
	List<String> fileAbsolutePathLinkedList = new LinkedList<String>();
	@Test
	public void testdd(){
		copyJavaPath("E:\\mavenproject\\project\\tom-javase","javase.txt");
	}
	public void copyJavaPath(String fromDir,String TOFILEPATH) {
		File fromfile = new File(fromDir);
		File toFile = new File(TOFILEPATH);
		if(toFile.exists()){
			System.out.println(toFile.delete());
		}
		getAbsolutePath(fromfile,toFile);
		//最后一次找到的java文件数量不满足写入文件的条件,在程序运行结束的时候才将这部分数据写入
		writeToTxt(fileAbsolutePathLinkedList, toFile);
		fileAbsolutePathLinkedList.clear();
		closeIO(bufferedWriter);
	}
	
	private void getAbsolutePath(File file,File toFile) {
		File[] files = file.listFiles();
		for (File f : files) {
			if (f.isDirectory()) {
				getAbsolutePath(f,toFile);
			} else {
				//过滤出来java文件
				if (f.toString().endsWith(".java")) {
					System.out.println(f);
					fileAbsolutePathLinkedList.add(f.toString());
					count++;
					//每10个写入文本一次
					if(count==10){
						writeToTxt(fileAbsolutePathLinkedList, toFile);
						count=0;
						fileAbsolutePathLinkedList.clear();
					}
				}
			}
		}
	}
	/**
	 * @Method: writeToTxt
	 * @Description:这个方法只负责将List中的数据写入文件
	 * @param: @param list java文件绝对路径
	 * @param: @param file 目的地
	 * @return: void
	 * @date 2016年5月21日
	 * @author TOM
	 */
	private void writeToTxt(List<String> list,File file){
		try {
			//设置为true,那么就是在原有文件数据基础上添加信息;
			FileOutputStream fileOutputStream = new FileOutputStream(file,true);
			bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "UTF-8"));
			for(String str:list){
				bufferedWriter.write(str);
				bufferedWriter.newLine();
			}
			bufferedWriter.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	private void closeIO(BufferedWriter bufferedWriter){
		if(bufferedWriter!=null){
			try {
				bufferedWriter.close();
			} catch (IOException e) {
				LoggerUtil.writeToLogger(CopyJavaPath.class, LoggerTypeEnum.ERROR, "bufferedWriter流无法关闭");
				System.out.println("流无法关闭");
			}
		}
	}
}
