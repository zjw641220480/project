package cn.itcast.zjw.servlet.response.io;

import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
/**
 * 
 * @ClassName:ResponsePhoto
 * @Description:使用IO在页面显示图片
 * @author TOM
 * @Time: 2016年7月9日下午4:27:35
 */
public class ResponsePhoto extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ResponsePhoto() {
        super();
    }
    /*
     * 演示相应字节数据
     * */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//在webapp目录下的,直接这样来获取文件绝对路径
		String path = "/image/my.jpg";
		String filePath = request.getServletContext().getRealPath(path);
		System.out.println(filePath);
		// 把一张图片读取到字节数组中
		FileInputStream fileInputStream = new FileInputStream(filePath);
		byte[] bytes = IOUtils.toByteArray(fileInputStream);
		response.getOutputStream().write(bytes);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
