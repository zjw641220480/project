# tom-javase-design
csdn上面看到的建造者模式,不是特别明白,觉得有些拖
建造模式分为两个很重要的部分
1:一个部分是builder接口,这里定义了如何构建各个部件;是具体建造者的抽象
2:另一个部分是Director,Director是知道如何组合来构建产品,也就是说Director负责整体的构建算法,而且通常是
分步骤的来执行,也就是说如何组装这些部件
不管如何变化,建造模式都存在这么两个步骤,一个是产品的构造者,一个是产品整体构建的算法