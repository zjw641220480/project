# tom-javase

	io流,socket,thread这三部分比较多,每天复习一个部分,

在取出Set,List以及Map的时候,因为Set和Map没有下标,底层不是数据,所以无法使用标准for循环来取出他们的数据

一个正常的类但是没有提供构造函数,说明不可以new对象,那么会直接想到该类中的方法都是静态的,
 但是发现该类中还有非静态方法,说明该类肯定提供了方法获取本类对象,而且该方法是静态的,并且返回值类型是基本类型;
由这个特点可以知道这个类使用了单例设计模式

//以本项目为根目录,在根下创建一个newFile.txt文件
File file = new File("newFile.txt");
//下面这句话会以本项目为根,在根下创建一个abc\kk的目录;
File file = new File("abc\\kk");
IO流中需要注意,路径前面什么都没有的时候是直接相对于项目的根路径(in.log),加斜杠的时候是相对于此项目所在的盘符,绝对路径(/in.log),比如C盘,如果是在包里面的时候,需要从src下开始寻找
