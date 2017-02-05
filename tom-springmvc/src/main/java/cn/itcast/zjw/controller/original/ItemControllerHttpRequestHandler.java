package cn.itcast.zjw.controller.original;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import cn.itcast.zjw.po.Items;

/**
 *
 * <p>Title:ItemControllerHttpRequestHandler.java</p>
 * <p>Description:入门程序,商品列表的查询,实现HttpRequestHandler接口</p>
 * @author TOM
 * @date 2017年2月3日下午3:10:33
 */
public class ItemControllerHttpRequestHandler implements HttpRequestHandler{

	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Items> itemList = new ArrayList<Items>();
		Items itemsA = new Items();
		itemsA.setName("联想笔记本handleRequest");
		itemsA.setPrice(6000);
		Items itemsB = new Items();
		itemsB.setName("华硕笔记本handleRequest");
		itemsB.setPrice(5000);
		Items itemsC = new Items();
		itemsC.setName("戴尔笔记本handleRequest");
		itemsC.setPrice(4000);
		itemList.add(itemsA);
		itemList.add(itemsB);
		itemList.add(itemsC);
		request.setAttribute("itemsList", itemList);
		request.getRequestDispatcher("itemsList").forward(request, response);;
	}
}
