package cn.itcast.zjw.controller.binding;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.zjw.po.ItemsCustom;
import cn.itcast.zjw.po.ItemsQueryVo;
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
	/**
	 * 
	 * @MethodName:initBinder
	 * @Description:使用WebDateBinder自定义属性编辑器,使用这种方式不方便在多个controller中进行使用.
	 * @param binder
	 * @Time:2017年2月8日下午10:39:42
	 * @author:Tom
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"), true));
	}
}
