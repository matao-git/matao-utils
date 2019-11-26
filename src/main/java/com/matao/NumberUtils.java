package com.matao;

import java.util.Random;

public class NumberUtils {
	
	/*
	* 百分比计算方法，返回值只要整数不需要小数。
	* 给一个当前数，和一个总数，计算当前数百分占比，例如参数为5和10，方法内部
	* 5除以10得0.5，再乘以100，返回50，注意四舍五入。页面就可以显示50%
	*/
	public static String  getPercent(Integer current,Integer total) {
		double b = (double)current/total;
		
		System.out.println(b);
		b = b*100;
		
		System.out.println(b);
		String format = String.format("%.0f", b);
		System.out.println(format);
		
		return format;
	}
	//随机获取指定范围数字
	public static int getMamMinNum(Integer min,Integer max){
		Random random = new Random();
		int num = random.nextInt(max-min+1)+min;
		return num;
	}
	
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
