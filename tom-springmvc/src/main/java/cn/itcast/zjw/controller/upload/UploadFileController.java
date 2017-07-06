package cn.itcast.zjw.controller.upload;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import cn.itcast.zjw.po.ItemsCustom;
import cn.itcast.zjw.service.ItemsService;

/**
 *
 * <p>Title:UploadFileController.java</p>
 * <p>Description:</p>
 * @author TOM
 * @date 2017年2月9日下午7:05:01
 */
@Controller
@RequestMapping("/upload")
public class UploadFileController {
	@Resource(name="itemsServiceImpl")
	private ItemsService itemsService;
	/**
	 * 
	 * @MethodName:uploadFile
	 * @Description:文件上传,要求上传文件的name值和MultipartFile参数名称一致
	 * @param pictureFile
	 * @param itemsCustom
	 * @return
	 * @Time:2017年2月9日下午7:21:25
	 * @author:Tom
	 * @throws Exception 
	 */
	@RequestMapping("/uploadFile")
	public String uploadFile(MultipartFile pictureFile,ItemsCustom itemsCustom) throws Exception{
		System.out.println("UploadFileController.uploadFile()");
		//进行图片上传
		if(pictureFile!=null){
			//图片上传成功后,将图片上传后的地址写入到数据库
			String filePath = "D:\\test\\page\\";
			//获得图片原始名称
			String originalFileName = pictureFile.getOriginalFilename();
			String newFileName = UUID.randomUUID()+originalFileName.substring(originalFileName.lastIndexOf("."));
			//新文件
			File file = new File(filePath+newFileName);
			//使用对象自带的写入方法
			pictureFile.transferTo(file);
			//图片上传成功,将新图片地址写入数据库
			itemsCustom.setPic(newFileName);
			itemsService.updateItems(itemsCustom.getId(), itemsCustom);
		}
		return "forward:/items/queryItems.action";
	}
}
