package cn.itcast.zjw.thread.test;

public class MyThread {
	public static void main(String[] args) {
		
	}
}

class InputResourceOne implements Runnable {
	private Resource resource;

	public InputResourceOne(Resource resource) {
		this.resource = resource;
	}

	public void run() {
		int x = 0;
		while (true) {
			this.resource.setResourceName("张三");
			this.resource.setSex("女");
		}
	}
}

class OutputResourceOne implements Runnable {
	private Resource resource;

	public OutputResourceOne(Resource resource) {
		this.resource = resource;
	}

	public void run() {
		while (true) {
			synchronized (resource) {
				System.out.println(this.resource.getResourceName() + "\t"
						+ this.resource.getResourceAge());
			}
		}
	}

}

class Resource {
	private String resourceName;
	private int resourceAge;
	private String sex;
	private boolean flag;
	
	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getResourceName() {
		return resourceName;
	}

	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}

	public int getResourceAge() {
		return resourceAge;
	}

	public void setResourceAge(int resourceAge) {
		this.resourceAge = resourceAge;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}
}
