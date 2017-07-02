package cn.itcast.zjw.design.decorator.derector;

import cn.itcast.zjw.design.decorator.Programmer;

public class SoftwareArchitect extends Derector{
	public SoftwareArchitect(Programmer programmer) {
        super(programmer);
    }

    @Override
    public void programme() {
        super.programme();
        //附加的责任或者功能
        System.out.println("我具有架构师的技能  我能设计总个网站或系统的骨架");
    }
}
