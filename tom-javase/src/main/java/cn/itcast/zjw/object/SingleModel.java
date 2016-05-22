package cn.itcast.zjw.object;

/** 
* @ClassName: SingleModel 
* @Description: 单例模式的演示;
* 这个是先初始化对象,称为:饿汉式;
* 当SingleModel类一进内存,就已经创建好了对象
* @author Tom
* @date 2016-2-28 
*/ 
public class SingleModel {
	private SingleModel(){}
	private static SingleModel singleModel = new SingleModel();
	public static SingleModel getInstance(){
		return singleModel;
	}
}
/** 
* @ClassName: SingleModel_2 
* @Description: 对象是方法被调用的时候才初始化,对象的延迟加载,称为懒汉式;
* SingleModel_2类进内存的时候,对象还没有存在,只有调用了getInstance方法的时候,才建立了对象;
* @author Tom
* @date 2016-2-28 
*/ 
class SingleModel_2{
	private static SingleModel_2 singleModel_2 = null;
	private SingleModel_2(){}
	public static synchronized SingleModel_2 getInstance(){
		if(singleModel_2==null){
			synchronized (SingleModel_2.class) {
				if(singleModel_2==null){
					singleModel_2 = new SingleModel_2();
				}
			}
		}
		//这里不需要else语句了,
		return singleModel_2;
	}
}
class SingleModelTest{
	public static void main(String[] args) {
		SingleModel.getInstance();
	}
}

