package cn.itcast.zjw.controller.returns;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import cn.itcast.zjw.po.ItemsCustom;
import cn.itcast.zjw.po.ItemsQueryVo;
import cn.itcast.zjw.service.ItemsService;

/**
 *
 * <p>Title:Returns.java</p>
 * <p>Description:三种方式的返回</p>
 * @author TOM
 * @date 2017年2月9日下午4:45:23
 */
@Controller
@RequestMapping("/return")
public class Returns {
	@Resource(name="itemsServiceImpl")
	private ItemsService itemsService;
	/**
	 * 
	 * @MethodName:returnModelAndView
	 * @Description:标准的返回ModelAndView
	 * @return
	 * @Time:2017年2月9日下午4:46:27
	 * @author:Tom
	 */
	@RequestMapping("/returnModelAndView")
	public ModelAndView returnModelAndView(){
		ItemsQueryVo itemsQueryVo = new ItemsQueryVo();
		ItemsCustom itemsCustom = new ItemsCustom();
		itemsCustom.setId(1);
		itemsQueryVo.setItemsCustom(itemsCustom);
		List<ItemsCustom> list = itemsService.findItemsList(itemsQueryVo);
		System.out.println(list);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("itemsList");
		modelAndView.addObject("itemsList", list);
		//使用下面一句话也可以实现重定向
		//modelAndView.setView(new RedirectView("return/returnVoid.action"));
		//下面两句是使用ModelAndView来实现请求转发和重定向;
		//modelAndView.setViewName("forward:/return/returnVoid.action");
		modelAndView.setViewName("redirect:/return/returnVoid.action");
		return modelAndView;
	}
	/**
	 * 
	 * @MethodName:returnVoid
	 * @Description:使用这种方式,可以很方便的输出json和xml格式的数据;
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * @Time:2017年2月9日下午4:49:44
	 * @author:Tom
	 */
	@RequestMapping("/returnVoid")
	public void returnVoid(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		ItemsQueryVo itemsQueryVo = new ItemsQueryVo();
		ItemsCustom itemsCustom = new ItemsCustom();
		itemsCustom.setId(1);
		itemsQueryVo.setItemsCustom(itemsCustom);
		List<ItemsCustom> list = itemsService.findItemsList(itemsQueryVo);
		System.out.println(list);
		itemsService.findListString();
		request.setAttribute("itemsList", list);
		//这里需要注意:当使用request来转向页面的时候,这里需要指定页面的完整路径;
		request.getRequestDispatcher("/WEB-INF/jsp/itemsList.jsp").forward(request, response);
	}
	/**
	 * 
	 * @MethodName:returnString
	 * @Description:方法返回字符串,字符串就是逻辑视图名,Model的作用就是就是将数据填充到Request作用域,在页面进行展示,可以实现重定向
	 * @param model
	 * @return
	 * @Time:2017年2月9日下午4:50:34
	 * @author:Tom
	 */
	@RequestMapping("/returnString")
	public String returnString(Model model){
		ItemsQueryVo itemsQueryVo = new ItemsQueryVo();
		ItemsCustom itemsCustom = new ItemsCustom();
		itemsCustom.setId(1);
		itemsQueryVo.setItemsCustom(itemsCustom);
		List<ItemsCustom> list = itemsService.findItemsList(itemsQueryVo);
		System.out.println(list);
		model.addAttribute("itemsList", list);
		//使用这种方式进行不同Controller之间请求转发时候的书写;
		//"forward:/items/queryItems.action";
		//"redirect:/items/queryItems.action"
		return "itemsList";
	}
}
