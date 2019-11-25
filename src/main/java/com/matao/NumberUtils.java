package com.matao;

public class NumberUtils {
	
	/**
	 *  求百分比的整数部分的字符�?
	 * @param n
	 * @param m
	 * @return
	 */
	public static String percent(int n ,int m) {
		return 100*n/m + "%";
	}
	/**
	 * 
	    * @Title: isNumber
	    * @Description:是否是数字
	    * @param @param num
	    * @param @return    参数
	    * @return boolean    返回类型
	    * @throws
	 */
	public static boolean isNumber(int num) {
		
		if(num - 0 == num) {
			return true;
		} else {
			return false;
		}
	}
}
