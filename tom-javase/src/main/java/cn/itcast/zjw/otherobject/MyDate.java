package cn.itcast.zjw.otherobject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyDate {
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);//打印的时间
		DateFormat dateFormat = new SimpleDateFormat("yyy-MM-dd HH:mm:ss");
		System.out.println(dateFormat.format(date));
	}
}
