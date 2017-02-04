package cn.itcast.zjw.controller.original;


import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import cn.itcast.zjw.po.Items;

/**
 *
 *<p>Title:ItemController.java</p>
 *<p>Description:入门程序,商品列表的查询,实现Controller接口</p>
 * @author TOM
 * @date 2017年2月3日上午11:08:54
 */
public class ItemController implements Controller{

	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		List<Items> itemList = new ArrayList<Items>();
		Items itemsA = new Items();
		itemsA.setName("联想笔记本");
		itemsA.setPrice(6000f);
		Items itemsB = new Items();
		itemsB.setName("华硕笔记本");
		itemsB.setPrice(5000f);
		Items itemsC = new Items();
		itemsC.setName("戴尔笔记本");
		itemsC.setPrice(4000f);
		itemList.add(itemsA);
		itemList.add(itemsB);
		itemList.add(itemsC);
		ModelAndView modelAndView = new ModelAndView();
		//modelAndView.setViewName("/index.jsp");
		//modelAndView.setViewName("/WEB-INF/jsp/itemsList.jsp");
		modelAndView.setViewName("itemsList");
		modelAndView.addObject("itemsList", itemList);
		
		return modelAndView;
	}

}
