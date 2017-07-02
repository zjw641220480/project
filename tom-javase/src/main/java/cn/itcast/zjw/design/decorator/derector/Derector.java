package cn.itcast.zjw.design.decorator.derector;

import cn.itcast.zjw.design.decorator.Programmer;

/**
 * 
 * <p>Titile:Derector</p>
 * <p>Description:装饰角色,以组合的方式拥有最初的被装饰的目标类,这个包中的三个类组成了装饰者体系</p>
 * @author TOM
 * @date 2017年7月2日 下午3:56:02
 */
public abstract class Derector implements Programmer{
	private Programmer programmer;
	public Derector(Programmer programmer) {
		this.programmer = programmer;
	}
	public void programme() {
		programmer.programme();
        //附加的责任或者功能
	}

}
