package cn.itcast.zjw.controller.binding;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.zjw.po.ItemsCustom;
import cn.itcast.zjw.service.ItemsService;

/**
 *
 * <p>Title:BindIng.java</p>
 * <p>Description:主要用来演示参数绑定,专门有一个注解(RequestParam,value指定绑定的参数名)
 * 	对于简单数据类型可以直接绑定,
 * </p>
 * @author TOM
 * @date 2017年2月7日下午2:49:23
 */
@RequestMapping("/binding")
public class BindIng {
	@Resource(name = "itemsService")
	private ItemsService itemsService;
	
	/**
	 * 
	 * @MethodName:editItemsSubmit
	 * @Description:简单POJO进行绑定
	 * @Time:2017年2月7日下午5:53:17
	 * @author:Tom
	 * @throws Exception 
	 */
	@RequestMapping("/editItemsSubmit")
	public void editItemsSubmit(ItemsCustom itemsCustom,HttpServletRequest request,HttpServletResponse response) throws Exception{
		itemsService.updateItems(itemsCustom.getId(), itemsCustom);
		request.getRequestDispatcher("queryItems.action").forward(request, response);
	}
	
}
