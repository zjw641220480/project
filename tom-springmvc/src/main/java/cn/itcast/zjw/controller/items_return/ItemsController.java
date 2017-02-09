package cn.itcast.zjw.controller.items_return;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.zjw.po.ItemsCustom;
import cn.itcast.zjw.po.ItemsQueryVo;
import cn.itcast.zjw.service.ItemsService;

/**
 *
 * <p>Title:ItemsController.java</p>
 * <p>Description:注解第一案例,包括了RequestMapping演示,以及重要的各种类型返回值的演示
 * 	1:返回ModelAndView
 *  2:返回String字符串,直接指定jsp页面,可以实现重定向
 *  3:无返回值,可以很方便的返回json和xml格式的数据,
 * </p>
 * @author TOM
 * @date 2017年2月4日下午5:05:41
 */
@Controller
//定义URL的根路径,窄化URL
@RequestMapping("/items")
public class ItemsController {
	@Resource(name = "itemsServiceImpl")
	private ItemsService itemsService;

	public ItemsService getItemsService() {
		return itemsService;
	}

	public void setItemsService(ItemsService itemsService) {
		this.itemsService = itemsService;
	}
	/**
	 * 
	 * @MethodName:queryItems
	 * @Description:第一个案例,返回ModelAndView
	 * @return
	 * @Time:2017年2月7日下午2:16:16
	 * @author:Tom
	 */
	@RequestMapping("/queryItems")
	public ModelAndView queryItemsReturnModelAndView() {
		ItemsQueryVo itemsQueryVo = new ItemsQueryVo();
		ItemsCustom itemsCustom = new ItemsCustom();
		itemsCustom.setId(1);
		itemsQueryVo.setItemsCustom(itemsCustom);
		List<ItemsCustom> list = itemsService.findItemsList(itemsQueryVo);
		System.out.println(list);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("itemsList");
		modelAndView.addObject("itemsList", list);
		return modelAndView;
	}
	/**
	 * 
	 * @MethodName:queryItemsReturnString
	 * @Description:方法返回字符串,字符串就是逻辑视图名,Model的作用就是就是将数据填充到Request作用域,在页面进行展示
	 * @param model
	 * @return
	 * @Time:2017年2月7日下午2:18:34
	 * @author:Tom
	 */
	@RequestMapping("queryItemsReturnString")
	public String queryItemsReturnString(Model model){
		ItemsQueryVo itemsQueryVo = new ItemsQueryVo();
		ItemsCustom itemsCustom = new ItemsCustom();
		itemsCustom.setId(1);
		itemsQueryVo.setItemsCustom(itemsCustom);
		List<ItemsCustom> list = itemsService.findItemsList(itemsQueryVo);
		System.out.println(list);
		model.addAttribute("itemsList", list);
		return "itemsList";
	}
	/**
	 * 
	 * @MethodName:queryItemsReturnVoid
	 * @Description:返回Void,使用这种方式,可以很方便的输出json和xml格式的数据;
	 * @param request
	 * @param response
	 * @Time:2017年2月7日下午2:33:47
	 * @author:Tom
	 * @throws IOException 
	 * @throws ServletException 
	 */
	@RequestMapping("/queryItemsReturnVoid")
	public void queryItemsReturnVoid(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		ItemsQueryVo itemsQueryVo = new ItemsQueryVo();
		ItemsCustom itemsCustom = new ItemsCustom();
		itemsCustom.setId(1);
		itemsQueryVo.setItemsCustom(itemsCustom);
		List<ItemsCustom> list = itemsService.findItemsList(itemsQueryVo);
		System.out.println(list);
		request.setAttribute("itemsList", list);
		//这里需要注意:当使用request来转向页面的时候,这里需要指定页面的完整路径;
		request.getRequestDispatcher("/WEB-INF/jsp/itemsList.jsp").forward(request, response);
	}
	/**
	 * 
	 * @MethodName:editItems
	 * @Description:商品修改页面显示
	 * @return
	 * @throws Exception
	 * @Time:2017年2月6日下午5:49:26
	 * @author:Tom
	 */
	@RequestMapping(value = "editItems", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView editItems() throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		ItemsCustom itemsCustom = itemsService.findItemsById(1);
		modelAndView.addObject("itemsCustom", itemsCustom);
		modelAndView.setViewName("editItem");
		return modelAndView;
	}
	/**
	 * 
	 * @MethodName:editItemsSubmit
	 * @Description:真正进行商品修改
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
