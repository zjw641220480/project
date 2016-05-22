/**
 * @Project: tom-javase @(#) FileDemoTwo.java
 * 
 * Copyright (c) 2016, Credan-版权所有
 * 
 */
package cn.itcast.zjw.io.file;

import java.io.File;
import java.io.FilenameFilter;

import org.junit.Test;

/**
 * Class <code>FileDemoTwo</code> 
 * @Time 2016年5月21日 上午10:11:21
 * @author: TOM
 * @version 1.0.0
 * @since  1.6
 */
public class FileDemoTwo {
	/**
	 * Method <code>testList</code>
	 * @Description <b>最简单的获取指定文件夹下面所有文件</b>
	 * @param:  
	 * @return: void
	 * @date 2016年5月21日
	 * @author TOM
	 */
	@Test
	public void testList(){
		//调用list方法的File对象必须是封装了一个目录,该目录还必须存在
		File file = new File("d:\\");
		String[] fileNames = file.list();
		for(String fileName:fileNames){
			System.out.println(fileName);
		}
	}
	/**
	 * Method <code>testListTwo</code>
	 * @Description <b>FilenameFilter过滤器的使用</b>
	 * @param:  
	 * @return: void
	 * @date 2016年5月21日
	 * @author TOM
	 */
	@Test
	public void testListTwo(){
		File file = new File("E:\\mavenproject\\project\\tom-javase");
		//使用FiliNameFilter过滤器掉非指定的文件
		File[] fileNames = file.listFiles(new FilenameFilter() {
			public boolean accept(File file, String name) {
				/*if(name.endsWith(".txt")){
					return true;
				}
				return false;*/
				//代码的规范性,下面一句最正规
				return name.endsWith("txt");
			}
		});
		for(File fileName:fileNames){
			System.out.println(fileName);
		}
	}
	
}
