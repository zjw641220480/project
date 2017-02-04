/**
 * @Project: tom-javase @(#) DiGui.java
 * 
 * Copyright (c) 2016, Credan-版权所有
 * 
 */
package cn.itcast.zjw.io.file;

import java.io.File;

import org.junit.Test;

/**
 * <p>
 * 列出指定目录下文件或者文 件夹,包含子目录中的内容,因为目录中还有目录,只要使用同一个目录功能的函数完成即可
 * 在列出过程中出现的还是目录的话,还可以再次调用此功能,也就是函数本身调用本身,这种 表现形式或者编程手法叫作递归;(递归函数调用自身的时候需要加上判断条件)
 * 递归需要注意的:
 * 1:限定条件
 * 2:要注意递归的次数,尽量避免内存溢出
 * 
 * </p>
 * */
/**
 * @ClassName: DiGui
 * @Description:递归方法的演示;
 * @Time 2016年5月21日 上午11:22:20
 * @author: TOM
 * @version 1.0.0
 * @since 1.6
 */
public class DiGui {
	/**
	 * @Method: testDiGui
	 * @Description <b>使用递归方式查找d盘下 某一个目录下的所有java文件</b>
	 * @param:
	 * @return: void
	 * @date 2016年5月21日
	 * @author TOM
	 */
	@Test
	public void testDiGui() {
		File file = new File("E:\\mavenproject\\project");
		showDir(file);
		System.out.println(i);
	}

	private static int i = 0;

	
	/**
	 * @Method: showDir
	 * @Description:
	 * @param: @param file 
	 * @return: void
	 * @date 2016年5月21日
	 * @author TOM
	 */
	private void showDir(File file) {
		System.out.println(file + "\t目录");
		File[] files = file.listFiles();
		for (File f : files) {
			i++;
			//这个就是递归调用的判断条件.从而可以跳出递归
			if (f.isDirectory()) {
				showDir(f);
			} else {
				System.out.println(f);
			}
		}
	}
}
