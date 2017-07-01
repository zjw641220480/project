package cn.itcast.zjw.design.builder.mail.build;

import cn.itcast.zjw.design.builder.mail.product.WelcomeMessage;

public class WelcomeBuilder extends Builder {

	public WelcomeBuilder() {
		msg = new WelcomeMessage();
	}

	@Override
	public void buildSubject() {
		msg.setSubject("欢迎标题");
	}

	@Override
	public void buildBody() {
		msg.setBody("欢迎内容");
	}

	
}
