package cn.itcast.zjw.thread.test;

public class MyProduceTest {
	public static void main(String[] args) {
		Respurce resource = new Respurce();
		ProduceName name = new ProduceName(resource);
		ProduceSex sex = new ProduceSex(resource);
		Thread nameThread = new Thread(name);
		Thread sexThread = new Thread(sex);
		nameThread.start();
		sexThread.start();
		boolean flag = true;
		while(flag){
			if(resource.nameFlag&&resource.sexFlag){
				try {
					Thread.sleep(300);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("MyTest.main()");
				System.out.println(resource.getName());
				System.out.println(resource.getSex());
				flag = false;
			}
		}
	}
}
class ProduceName implements Runnable{
	private Respurce resource;
	public ProduceName(Respurce resource) {
		this.resource=resource;
	}
	public void run() {
		synchronized (resource) {
			System.out.println("ProduceName.run()");
			resource.setName("zhangsan");
			resource.setNameFlag(true);
		}
	}
}
class ProduceSex implements Runnable{
	private Respurce resource;
	public ProduceSex(Respurce resource) {
		this.resource=resource;
	}
	public void run() {
		synchronized (resource) {
			System.out.println("ProduceSex.run()");
			resource.setSex("nan");
			resource.setSexFlag(true);
		}
	}
}
class Respurce{
	String name;
	String sex;
	boolean nameFlag;
	boolean sexFlag;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public boolean isNameFlag() {
		return nameFlag;
	}
	public void setNameFlag(boolean nameFlag) {
		this.nameFlag = nameFlag;
	}
	public boolean isSexFlag() {
		return sexFlag;
	}
	public void setSexFlag(boolean sexFlag) {
		this.sexFlag = sexFlag;
	}
}