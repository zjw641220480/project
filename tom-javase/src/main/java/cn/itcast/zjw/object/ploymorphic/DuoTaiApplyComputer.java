package cn.itcast.zjw.object.ploymorphic;

/** 
* @ClassName: DuoTaiApplyComputer 
* @Description: 多态的一个电脑运行事例;
* @author Tom
* @date 2016-2-29 
*/ 
public class DuoTaiApplyComputer {
	public static void main(String[] args) {
		MainBoard mainBoard = new MainBoard();
		mainBoard.run();
		mainBoard.usePCI(null);
		mainBoard.usePCI(new NetCard());
		mainBoard.usePCI(new SoundCard());
	}
}

/*class MainBoard {
	public void run(){
		System.out.println("MainBoard.run()");
	}
}

class NetCard {
	public void open(){
		System.out.println("NetCard.open()");
	}
	public void close(){
		System.out.println("NetCard.close()");
	}
}*/
interface PCI {
	public void open();
	public void close();
}
class MainBoard {
	public void run(){
		System.out.println("MainBoard.run()");
	}
	public void usePCI(PCI pci){//PCI pci = new NetCard();接口型引用指向自己的引用;
		if(pci!=null){
			pci.open();
			pci.close();
		}
	}
}
class NetCard implements PCI{
	public void open(){
		System.out.println("NetCard.open()");
	}
	public void close(){
		System.out.println("NetCard.close()");
	}
}
class SoundCard implements PCI{
	public void open(){
		System.out.println("SoundCard.open()");
	}
	public void close(){
		System.out.println("SoundCard.close()");
	}
}
