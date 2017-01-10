package cn.itcast.zjw.io.file;

import java.io.File;
import java.io.IOException;

import org.junit.Test;
/*
 * File类常见方法: 
 * 	1:创建 
 * 		createNewFile:在指定位置创建文件,如果该文件已经存在,则不创建,返回false;
 *  和输出流不一样,输出流对象一建立就会创建文件,而且若文件已经存在,则会覆盖原文件; 
 *  	createTempFile:创建临时文件;
 *  2:删除 delete:删除失败返回false; deleteOnExit:在程序退出时,删除指定文件 ;
 *  3:判断
 *  	boolean exists():判断文件或者文件夹是否存在,boolean
 *  	boolean isDirectory():判断是否为文件夹; 
 *  	boolean isFile():判断是否为文件,
 *  	boolean isHidden():判断是否为隐藏文件 
 *  4:获取信息:
 *  	getName():
 *  	getPath():
 *  	getParent();
 * */

/** 
 * @ClassName: FileDemo
 * @Description:File对象的Demo
 * @Time 2016年6月1日 下午8:53:49
 * @author: TOM
 * @version 1.0.0
 * @since  1.6
 */
public class FileDemo {

	/**
	 * Method <code>testSimple</code>
	 * 
	 * @Description <b></b>
	 * @param:
	 * @return: void
	 * @date 2016年5月21日
	 * @author TOM
	 */
	@Test
	public void testSimple() {
		File file = new File("abc\\kk");
		// file.mkdir();// 这种方式只能创建一级目录;
		file.mkdirs();// 这种方式既可以创建一级目录,同时也可以创建多级目录;
		File file2 = new File("file.txt");
		// 若文件本身不存在,那么它在判断是否为文件或者文件夹的时候都会是false
		System.out.println(file2.isFile());
		System.out.println(file2.isDirectory());
	}

	/**
	 * @Description: 创建文件,当文件创建成功后,不再继续创建
	 * @return void
	 * @throws
	 * @author Tom
	 * @date 2016年5月19日
	 */
	@Test
	public void createFile() {
		File file = new File("newFile.txt");
		try {
			System.out.println(file.createNewFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @Description: 删除指定文件
	 * @return void
	 * @throws
	 * @author Tom
	 * @date 2016年5月19日
	 */
	@Test
	public void deleteFile() {
		File file = new File("newFile.txt");
		System.out.println(file.exists());
		// System.out.println(file.delete());
		// 当程序运行完成之后将此文件删除,不论是否报异常都会将这个文件删除掉
		// file.deleteOnExit();
	}

	/**
	 * Method <code>createTempFile,</code>
	 * 
	 * @Description <b>创建临时文件,然后即刻删除</b>
	 * @param:
	 * @return: void
	 * @throws:
	 * @date 2016年5月21日
	 * @author TOM
	 */
	@Test
	public void createTempFile() {
		try {
			File file = File.createTempFile("ttt", ".txt");
			System.out.println(file);
			file.deleteOnExit();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("FileDemo.createTempFile()");
	}

	/**
	 * Method <code>testCanExecute</code>
	 * 
	 * @Description <b>测试应用程序是否可以执行此抽象路径名表示的文件。</b>
	 * @param:
	 * @return: void
	 * @date 2016年5月21日
	 * @author TOM
	 * @throws IOException
	 */
	@Test
	public void testCanExecute() throws IOException {
		File file = new File("charset.txt");
		System.out.println(file.isFile());
		System.out.println(file.canExecute());
		// 通过java虚拟机启动程序;
		Runtime.getRuntime().exec("D:\\Dict\\YodaoDict.exe");
	}
	/**
	 * Method <code>testGet</code>
	 * @Description <b>流中get相关方法演示</b>
	 * @param:  
	 * @return: void
	 * @date 2016年5月21日
	 * @author TOM
	 */
	@Test
	public void testGet(){
		//当文件名为相对路径名的时候
		File file = new File("charset.txt");
		System.out.println(file.getName());
		System.out.println(file.getPath());
		System.out.println(file.getParent());//该方法返回的是绝对路径中的父目录
		System.out.println(file.getAbsolutePath());//这个方法不论是对于相对路径还是绝对路径,输出的都是绝对路径
		//当文件名为绝对路径名的时候
		File file2 = new File("E:\\mavenproject\\project\\tom-javase\\charset.txt");
		System.out.println(file2.getName());
		System.out.println(file2.getPath());
		System.out.println(file2.getParent());
		System.out.println(file2.getAbsolutePath());
		System.out.println(file2.lastModified());
	}
	@Test
	public void testRenameTo(){
		File file = new File("newFile.txt");
		System.out.println(file.renameTo(file));
	}
}
