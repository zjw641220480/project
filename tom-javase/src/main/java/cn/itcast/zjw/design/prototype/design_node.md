# tom-javase-design
原型模式:关于浅克隆和深克隆;
原型模式属于对象的创建模式,通过给出一个原型对象,来指明所有创建对象的类型,然后复制这个原型对象的方法创建出更多同类型的对象,也就是复制粘贴,
原型模式主要用于对象的复制,被复制的对象需要具备下面两个条件
1)实现Cloneable接口
2)重写Object类中的clone方法,
浅克隆:只负责克隆按值传递的数据,而不复制它所引用的对象,也就是说,被复制的类中引用到的对象,还是指向原来的对象,(只复制其本身)

浅克隆和深克隆的区别:
主要体现在数据类型上
	针对浅克隆
	当基本数据类型和String类型的时候:两个对象各自有自己的存储空间,其指针的值不一样(hash值不一样),其中一个修改,另一个对象中数据不会被修改
	当为引用数据类型,(List,Object)的时候:两个对象引用同一个地址,一个对象中的引用对应的值修改,另一个对象也会随之修改
	针对深克隆
	所有的都会从原对象中被克隆出来一份,两者之间数据完全不共享,深克隆要考虑深度的问题;深克隆,针对引用类型,需要自己进行赋值
	
深克隆这里不再进行描述
	
