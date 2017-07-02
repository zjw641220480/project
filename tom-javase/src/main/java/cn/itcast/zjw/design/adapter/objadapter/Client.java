package cn.itcast.zjw.design.adapter.objadapter;

public class Client {
	public static void main(String[] args) {
        //使用特殊功能类，即适配类，  
        // 需要先创建一个被适配类的对象作为参数  
        Target adapter = new Adapter(new Adaptee());  
        adapter.request();  
    }
}
