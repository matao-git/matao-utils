package com.matao;

public class Utils {
	/**
	 * 判断源字符串是否有值，空引号也算没值；
	 * @param str
	 * @return 
	 * @return
	 */
	public static  boolean hasText(String str) {
		//return !(str==null || 0== str.trim().length());
		return str!=null && 0 < str.trim().length();   
	
	}
	
	/**
	 * 判断源字符串是否为空，空引号也算没有值；
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		
		//return (str==null|| "".equals(str.trim()));
		return (str==null || 0== str.trim().length());
	}
	/**
	 * 判断是否为字符串
	 * @param str
	 * @return
	 */
	public static boolean isNumber(String str) {
		
		String reg = "[0-9]+[.]?[0-9]+";
		return str.matches(reg);
	}
}
