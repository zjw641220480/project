package cn.itcast.zjw.design.builder.mail;

import cn.itcast.zjw.design.builder.mail.build.Builder;
import cn.itcast.zjw.design.builder.mail.build.WelcomeBuilder;

public class Client {
	public static void main(String[] args) {
        // TODO Auto-generated method stub
		Builder builder = new WelcomeBuilder();
        Director director = new Director(builder);
        director.construct("toAddress@45126184@qq.com", "fromAddress@110.com");
    }
}
