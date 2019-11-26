package com.matao;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
/**
 * 
    * @ClassName: DateUtils
    * @Description: 日期工具类
    * @author 马涛
    * @date 2019年11月17日
    *
 */
public class DateUtils {
	
	 //计算从之前日期到现在的年龄
    public   static int countAge(Date date){
		SimpleDateFormat sdf = new	SimpleDateFormat("yyyy");
		int thisyear = Integer.valueOf(sdf.format(new Date()));
		int finalyear = Integer.valueOf(sdf.format(date));
		return thisyear-finalyear;
	}
	
	public static void main(String[] args) {
		
		Date birth = new Date(100, 0, 6);
		int age = calAge(birth);
		System.out.println("age is " + age);
		
		System.out.println("今天的月初是 " + getMonthStart(new Date()));
		
		
		System.out.println("今天的月末是 " + getMonthEnd(new Date(119, 1, 23)));
		
		
	}
	
	
	/**
	 * 
	 * @param birthday
	 * @return
	 */
	public static  int calAge(Date birthday) {
		 new HashMap<>();
		Calendar cal = Calendar.getInstance();  
		cal.setTime(birthday);
		//获取出生的年月日
		int birthYear = cal.get(Calendar.YEAR);
		int birthMonth = cal.get(Calendar.MONTH);
		int birthDate = cal.get(Calendar.DAY_OF_MONTH);
		
		// 获取今天的年月日
		cal.setTime(new Date());
		int currentYear = cal.get(Calendar.YEAR);
		int currentMonth = cal.get(Calendar.MONTH);
		int currentDate = cal.get(Calendar.DAY_OF_MONTH);
		
		int age = currentYear-birthYear;
		if(currentMonth<birthMonth)
			age--;
		else if (currentMonth==birthMonth){
			if(currentDate<birthDate)
				age--;
		}
		return age;
	}
	
	/**
	 * 判断是否为当天
	 * @param date
	 * @return
	 */
	public static boolean isToday(Date date) {
		SimpleDateFormat smt = new SimpleDateFormat("yyyyMMdd");
		
		String dateStr = smt.format(date);
		String todayStr = smt.format(new Date());
		return dateStr.equals(todayStr);
		
	}
	
	
	/**
	 * 判断是否为今年
	 * @param date
	 * @return
	 */
	public static boolean isThisYear(Date date) {
		SimpleDateFormat smt = new SimpleDateFormat("yyyy");
		
		String dateStr = smt.format(date);
		String todayStr = smt.format(new Date());
		return dateStr.equals(todayStr);
	}
	
	
	/** 
	 *  
	 * 给定时间对象，初始化到该月初的1日0时0分0秒0毫秒
	 * 例如  给定 2017-08-23 13:24:16  返回 2017-08-01 00:00:00 
	 * @return
	 */
	public static Date getMonthStart(Date date) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		//设置0秒
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.AM_PM,Calendar.AM);
		cal.set(Calendar.DAY_OF_MONTH,1);
		return cal.getTime();
	}
	
	/**
	 * 求月�?
	 * @param date
	 * @return
	 */
	public static Date getMonthEnd(Date date) {
		
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		//设置0秒
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR, 0);
		cal.set(Calendar.AM_PM,Calendar.AM);
		cal.set(Calendar.DAY_OF_MONTH,1);
		cal.add(Calendar.MONTH, 1);
		cal.add(Calendar.SECOND, -1);
		return cal.getTime();
	}
	/**
	 * 
	 * @Title: randomDate 
	 * @Description: TODO
	 * @param beginDate 开始时间
	 * @param endDate 结束时间
	 * @return
	 * @return: Date
	 */
	public static Date randomDate(String beginDate, String endDate) {  
        try {  
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");  
            Date start = format.parse(beginDate);// 构造开始日期  
            Date end = format.parse(endDate);// 构造结束日期  
            // getTime()表示返回自 1970 年 1 月 1 日 00:00:00 GMT 以来此 Date 对象表示的毫秒数。  
            if (start.getTime() >= end.getTime()) {  
                return null;  
            }  
            long date = random(start.getTime(), end.getTime());  

            return new Date(date);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        return null;  
    }  
	/**
	 * 
	 * @Title: random 
	 * @Description: 随机生成时间
	 * @param begin
	 * @param end
	 * @return
	 * @return: long
	 */
    private static long random(long begin, long end) {  
        long rtn = begin + (long) (Math.random() * (end - begin));  
        // 如果返回的是开始时间和结束时间，则递归调用本函数查找随机值  
        if (rtn == begin || rtn == end) {  
            return random(begin, end);  
        }  
        return rtn;  
    }  
}
