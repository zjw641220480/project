package cn.itcast.zjw.controller.items;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.zjw.po.ItemsCustom;
import cn.itcast.zjw.po.ItemsQueryVo;
import cn.itcast.zjw.service.ItemsService;

/**
 *
 * <p>Title:ItemsController.java</p>
 * <p>Description:注解第一案例,包括了RequestMapping演示
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
	 * @MethodName:editItems
	 * @Description:商品修改页面显示
	 * @return
	 * @throws Exception
	 * @Time:2017年2月6日下午5:49:26
	 * @author:Tom
	 */
	@RequestMapping(value = "editItems", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView editItems(int id) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		ItemsCustom itemsCustom = itemsService.findItemsById(id);
		modelAndView.addObject("itemsCustom", itemsCustom);
		modelAndView.setViewName("editItem");
		//用于验证运行时异常int a = 1/0;
		return modelAndView;
	}
	/**
	 * 
	 * @MethodName:editItemsSubmit
	 * @Description:真正进行商品修改,回显以及校验
	 * @Time:2017年2月7日下午5:53:17
	 * @author:Tom
	 * @throws Exception 
	 */
	@RequestMapping("/editItemsSubmit")
	//@ModelAttribute(value="itemsCustom")这个注解用来数据的回显;
	//在要校验的pojo前面加上@Validated进行校验;并且在这个pojo后面加上BindingResult对象
	public void editItemsSubmit(@Validated @ModelAttribute(value="itemsCustom") ItemsCustom itemsCustom,BindingResult bindingResult,HttpServletRequest request,HttpServletResponse response) throws Exception{
		itemsService.updateItems(itemsCustom.getId(), itemsCustom);
		if(bindingResult.hasErrors()){
			System.out.println(bindingResult.getErrorCount());
			List<ObjectError> errors = bindingResult.getAllErrors();
			for(ObjectError error:errors){
				System.out.println(error.getDefaultMessage());
				System.out.println(error.getCode());
				System.out.println(error.getObjectName());
			}
			request.getRequestDispatcher("editItems.action").forward(request, response);
		}
		request.getRequestDispatcher("queryItems.action").forward(request, response);
	}
	/**
	 * 
	 * @MethodName:deleteItems
	 * @Description:批量删除
	 * @return
	 * @Time:2017年2月9日下午5:09:20
	 * @author:Tom
	 */
	@RequestMapping("/deleteItems")
	public String deleteItems(Integer[] delete_id){
		if(delete_id!=null){
			for(Integer id:delete_id){
				System.out.println("要删除的ID为:"+id);
			}
		}else{
			System.out.println("传递的数组为空");
		}
		return "success";
	}
	/**
	 * 
	 * @MethodName:initBinder
	 * @Description:使用WebDateBinder自定义属性编辑器,使用这种方式不方便在多个controller中进行使用.(只在此Controller中有用,并且优先级最高)
	 * @param binder
	 * @Time:2017年2月8日下午10:39:42
	 * @author:Tom
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder){
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
	}
	/**
	 * 
	 * @MethodName:getItemsType
	 * @Description:整个Controller范围的每个方法多了这么一个返回的对象;将共用的取数据的方法将返回值传到页面;
	 * @return
	 * @Time:2017年2月9日下午4:33:22
	 * @author:Tom
	 */
	@ModelAttribute("itemsType")
	public Map<String,String> getItemsType(){
		Map<String,String> map = new HashMap<String, String>();
		map.put("001", "游戏");
		map.put("002", "科技");
		map.put("003", "娱乐");
		return map;
	}
}
