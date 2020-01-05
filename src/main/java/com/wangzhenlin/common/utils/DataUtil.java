package com.wangzhenlin.common.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期工具类
 * @author Administrator
 *
 */
public class DataUtil {

	public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	/**
	 * 格式化日期
	 * @param theDate
	 * @param format
	 * @return
	 */
	public static String format(Date theDate,String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(theDate);
	}
	
	/**
	 * 解析日期
	 * @param theDateStr
	 * @param format
	 * @return
	 */
	public static Date parse(String theDateStr,String format) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		try {
			return simpleDateFormat.parse(theDateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 根据指定日期计算年龄
	 * @param theDate
	 * @return
	 */
	public static int getAge(Date theDate) {
		/** 获取当前日期的年月日 **/
		Calendar calendar = Calendar.getInstance();
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH);
		int day = calendar.get(Calendar.DAY_OF_MONTH);
		/** 获取生日的年月日 **/
		calendar.setTime(theDate);
		int theYear = calendar.get(Calendar.YEAR);
		int theMonth = calendar.get(Calendar.MONTH);
		int theDay = calendar.get(Calendar.DAY_OF_MONTH);
		/** 年龄 **/
		int age = year-theYear;
		/** 判断月份 **/
		if(month<theMonth) {
			age--;
		}
		/** 判断日期 **/
		if(month==theMonth && day<theDay) {
			age--;
		}
		return age;
	}
	
	/**
	 * 根据指定日期计算年龄  
	 * @param theDateStr
	 * @return
	 */
	public static int getAge(String theDateStr) {
		Date theDate = parse(theDateStr, "yyyy-MM-dd");
		return getAge(theDate);
	}
	
	/**、
	 * 求两个时间之间的天数
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int getDayNum(Date date1,Date date2) {
		int dayTime = 1000*60*60*24;
		Long time1 = date1.getTime();
		Long time2 = date2.getTime();
		Long abs = Math.abs(time1-time2);
		Double dayNumDouble = abs/dayTime*1.0;
		return dayNumDouble.intValue();
	}
	
	/**
	 * 求两个时间之间的天数
	 * @param date1Str
	 * @param date2Str
	 * @return
	 */
	public static int getDayNum(String date1Str,String date2Str) {
		Date date1 = parse(date1Str, "yyyy-MM-dd");
		Date date2 = parse(date2Str, "yyyy-MM-dd");
		return getDayNum(date1,date2);
	}
	
	/**
	 * 未来或过去距离现在还有多少天 
	 * @param date1Str
	 * @return
	 */
	public static int getDayNum(String date1Str) {
		Date date1 = new Date();
		Date date2 = parse(date1Str, "yyyy-MM-dd");
		return getDayNum(date1,date2);
	}
	
	/**
	 * 0-相等
	 * 1- date1大于date2
	 * -1 date1小于date2
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static int compare(Date date1,Date date2) {
		long time1 = date1.getTime();
		long time2 = date2.getTime();
		if(time1==time2) {
			return 0;
		}
		if(time1>time2) {
			return 1;
		}
		return -1;
	}
	
	/**
	 * 判断给定的日期是否在本周之内
	 * @param theDate
	 * @return
	 */
	public static boolean inWeek(Date theDate) {
		Calendar calendar = Calendar.getInstance();
		int theDay = calendar.get(Calendar.DAY_OF_WEEK);
		/** 当前周到第一天 **/
		calendar.set(Calendar.DAY_OF_WEEK, 1-theDay);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		Date startDate = calendar.getTime();
		/** 当前周到最后一天 **/
		calendar.add(Calendar.DAY_OF_WEEK, 6);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		calendar.set(Calendar.SECOND, 59);
		Date endDate = calendar.getTime();
		return compare(theDate,startDate)==1 && compare(endDate, theDate)==1;
	}
	
	/**
	 * 判断给定的日期是否在本周之内
	 * @param theDateStr
	 * @return
	 */
	public static boolean inWeek(String theDateStr) {
		Date theDate = parse(theDateStr, "yyyy-MM-dd");
		return inWeek(theDate);
	}
	
	/**
	 * 判断指定日期是否在本月  
	 * @param theDate
	 * @return
	 */
	public static boolean inMonth(Date theDate) {
		Date nowDate = new Date();
		String nowYyyymm = format(nowDate, "yyyy-MM");
		String theYyyymm = format(theDate, "yyyy-MM");
		return nowYyyymm.equals(theYyyymm);
	}
	
	/**
	 * 判断指定日期是否在本月
	 * @param theDateStr
	 * @return
	 */
	public static boolean inMonth(String theDateStr) {
		Date theDate = parse(theDateStr, "yyyy-MM-dd");
		return inMonth(theDate);
	}
	
	/***
	 * 获取指定日期月的结束的时间
	 * @param theDate
	 * @return
	 */
	public static Date getFirstDayOfMonth(Date theDate) {
		String theDateStr = format(theDate, "yyyy-MM-01");
		return parse(theDateStr, "yyyy-MM-dd");
	}
	
	/**
	 * 获取指定日期月的第一天
	 * @param theDateStr
	 * @return
	 */
	public static Date getFirstDayOfMonth(String theDateStr) {
		Date theDate = parse(theDateStr, "yyyy-MM-dd");
		return getFirstDayOfMonth(theDate);
	}
	
	
	/**
	 * 获取指定日期月份结束的时间
	 * @param theDate
	 * @return
	 */
	public static Date getLastDayOfMonth(Date theDate) {
		/** 取当月的第一天 **/
		Date firstDayOfMonth = getFirstDayOfMonth(theDate);
		/** 实例化日历控件 **/
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(firstDayOfMonth);
		/** 下月1号 **/
		calendar.add(Calendar.MONTH, 1);
		/** 减1秒，上月的最后日期 **/
		calendar.add(Calendar.SECOND, -1);
		return calendar.getTime();
	}
	
	/**
	 * 
	 * @param theDateStr
	 * @return
	 */
	public static Date getLastDayOfMonth(String theDateStr) {
		Date theDate = parse(theDateStr, "yyyy-MM-dd HH:mm:ss");
		return getLastDayOfMonth(theDate);
	}
	
	
	public static void main(String[] args) {
		System.out.println(format(getLastDayOfMonth("2020-02-06 12:33:33"), "yyyy-MM-dd HH:mm:ss"));
	}
	
}
