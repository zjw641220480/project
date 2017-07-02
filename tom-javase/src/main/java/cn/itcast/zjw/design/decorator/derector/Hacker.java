package cn.itcast.zjw.design.decorator.derector;

import cn.itcast.zjw.design.decorator.Programmer;

/**
 * 
 * <p>Titile:Hacker</p>
 * <p>Description:具体装饰者角色 </p>
 * @author TOM
 * @date 2017年7月2日 下午3:57:21
 */
public class Hacker extends Derector{

	public Hacker(Programmer programmer) {
		super(programmer);
	}
	@Override
    public void programme() {
		//调用的是被装饰的类中的相关方法
        super.programme();
        //附加的责任或者功能
        System.out.println("我具有黑客的技能   我能入侵别人的电脑");
    }
}
