package org.tom.util.code;

import java.io.BufferedInputStream;
import java.io.FileInputStream;

/**
 * @ClassName:GetEncoding
 * @Description:获取文本文件编码
 * @author TOM
 * @date 2016年5月24日 上午11:21:16
 * @version V1.0.0
 */
public class GetEncoding {
	public static void main(String[] args) {
		
	}
	public static String codeString(String fileName) throws Exception {
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(fileName));
		int p = (bin.read() << 8) + bin.read();
		String code = null;
		switch (p) {
		case 0xefbb:
			code = "UTF-8";
			break;
		case 0xfffe:
			code = "Unicode";
			break;
		case 0xfeff:
			code = "UTF-16BE";
			break;
		default:
			code = "GBK";
		}
		return code;
	}
}
