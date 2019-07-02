package com.util;

/**
 * 字符串工具类
 * @author Lisa Li
 *
 */
public class StringUtil {

	
	/**
	 * 判断字符串是否为�?
	 * 	为空，返回true；否则返回false
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if (str == null || "".equals(str.trim())) {
			return true;
		}
		return false;
	}
	
}
