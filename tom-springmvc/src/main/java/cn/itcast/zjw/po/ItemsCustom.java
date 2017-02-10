package cn.itcast.zjw.po;

/**
 * 
 * <p>Title: ItemsCustom</p>
 * <p>Description:商品信息的扩展类 </p>
 * <p>Company: www.itcast.com</p> 
 * @author	传智.燕青
 * @date	2015-3-20下午2:54:23
 * @version 1.0
 */
public class ItemsCustom extends Items{

	@Override
	public String toString() {
		return "ItemsCustom [getId()=" + getId() + ", getName()=" + getName() + ", getPrice()=" + getPrice()
				+ ", getPic()=" + getPic() + ", getCreatetime()=" + getCreatetime() + ", getDetail()=" + getDetail()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}
	
}
