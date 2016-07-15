package cn.itcast.zjw.thread.callable.product;

import java.util.concurrent.Callable;
/**
 * @ClassName:CallableProduct
 * @Description:所有生产者的父类,Callable借口需要复写的是call方法
 * @author TOM
 * @Time: 2016年7月14日上午11:15:31
 */
public interface CallableProduct extends Callable<Object>{

}
