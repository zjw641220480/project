package cn.itcast.zjw.controller.original;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.itcast.zjw.po.Items;

/**
 *
 * <p>Title:ItemControllerAnnotation.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年2月3日下午3:31:00
 */
@Controller
public class ItemControllerAnnotation {
	@RequestMapping(value="/queryItems")
	public void queryItems(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Items> itemList = new ArrayList<Items>();
		Items itemsA = new Items();
		itemsA.setName("联想笔记本handleRequest");
		itemsA.setPrice(6000f);
		Items itemsB = new Items();
		itemsB.setName("华硕笔记本handleRequest");
		itemsB.setPrice(5000f);
		Items itemsC = new Items();
		itemsC.setName("戴尔笔记本handleRequest");
		itemsC.setPrice(4000f);
		itemList.add(itemsA);
		itemList.add(itemsB);
		itemList.add(itemsC);
		request.setAttribute("itemsList", itemList);
		request.getRequestDispatcher("/WEB-INF/jsp/itemsList.jsp").forward(request, response);;
	}
}
