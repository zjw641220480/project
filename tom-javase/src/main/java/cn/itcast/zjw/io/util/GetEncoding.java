package cn.itcast.zjw.io.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

/**
 * @ClassName:GetEncoding
 * @Description:给一个绝对路径文件,查看其编码格式
 * @author TOM
 * @date 2016年5月24日 下午1:39:14
 * @version V1.0.0
 */
public class GetEncoding {

	/**
	 * @MethodName:codeString
	 * @Desription:获取文件编码,参数为String类型的绝对路径名
	 * @date:2016年5月24日
	 * @author TOM
	 * @param fileName
	 * @return
	 */
	public static String codeString(String fileName) {
		File file = new File(fileName);
		return getCharset(file);
	}

	/**
	 * @MethodName:codeFile
	 * @Desription:获取文件编码,参数为File
	 * @date:2016年5月24日
	 * @author TOM
	 * @param file
	 * @return
	 */
	public static String codeFile(File file) {
		return getCharset(file);
	}

	/**
	 * @MethodName:code
	 * @Desription:返回编码
	 * @date:2016年5月24日
	 * @author TOM
	 * @param file
	 * @return
	 */
	@SuppressWarnings("resource")
	public static String getCharset(File file) {
		String charset = "GBK"; // 默认编码
		byte[] first3Bytes = new byte[3];
		try {
			boolean checked = false;
			BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
			bis.mark(0);
			int read = bis.read(first3Bytes, 0, 3);
			if (read == -1)
				return charset;
			if (first3Bytes[0] == (byte) 0xFF && first3Bytes[1] == (byte) 0xFE) {
				charset = "UTF-16LE";
				checked = true;
			} else if (first3Bytes[0] == (byte) 0xFE && first3Bytes[1] == (byte) 0xFF) {
				charset = "UTF-16BE";
				checked = true;
			} else if (first3Bytes[0] == (byte) 0xEF && first3Bytes[1] == (byte) 0xBB && first3Bytes[2] == (byte) 0xBF) {
				charset = "UTF-8";
				checked = true;
			}
			bis.reset();
			if (!checked) {
				int loc = 0;
				while ((read = bis.read()) != -1) {
					loc++;
					if (read >= 0xF0)
						break;
					// 单独出现BF以下的，也算是GBK
					if (0x80 <= read && read <= 0xBF)
						break;
					if (0xC0 <= read && read <= 0xDF) {
						read = bis.read();
						if (0x80 <= read && read <= 0xBF)// 双字节 (0xC0 - 0xDF)
							// (0x80 -
							// 0xBF),也可能在GB编码内
							continue;
						else
							break;
						// 也有可能出错，但是几率较小
					} else if (0xE0 <= read && read <= 0xEF) {
						read = bis.read();
						if (0x80 <= read && read <= 0xBF) {
							read = bis.read();
							if (0x80 <= read && read <= 0xBF) {
								charset = "UTF-8";
								break;
							} else
								break;
						} else
							break;
					}
				}
				System.out.println(loc + " " + Integer.toHexString(read));
			}
			bis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return charset;
	}
}
