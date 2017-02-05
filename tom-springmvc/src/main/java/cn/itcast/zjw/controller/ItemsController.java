package cn.itcast.zjw.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.itcast.zjw.po.ItemsCustom;
import cn.itcast.zjw.po.ItemsQueryVo;
import cn.itcast.zjw.service.ItemsService;

/**
 *
 * <p>Title:ItemsController.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年2月4日下午5:05:41
 */
@Controller
public class ItemsController {
	@Resource(name="itemsServiceImpl")
	private ItemsService itemsService;
	
	public ItemsService getItemsService() {
		return itemsService;
	}

	public void setItemsService(ItemsService itemsService) {
		this.itemsService = itemsService;
	}
	@RequestMapping("/queryItems")
	public ModelAndView run(){
		ItemsQueryVo itemsQueryVo = new ItemsQueryVo();
		ItemsCustom itemsCustom = new ItemsCustom();
		itemsCustom.setId(1);
		itemsQueryVo.setItemsCustom(itemsCustom);
		List<ItemsCustom> list = itemsService.findItemsList(itemsQueryVo);
		System.out.println(list);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("index");
		modelAndView.addObject("list", list);
		return modelAndView;
		
	}
}
