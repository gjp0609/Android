package com.gjp0609.fish.frame.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * 基础 工具类
 * @author zar
 */
public class CommonUtil {

	private static final Random random = new Random();

	/**
	 * 返回一个随机数
	 * @param i
	 * @param j
	 * @return 随机数
	 */
	public static int getRandom(int i, int j) {
		if (j < i) {
			int tmp = j;
			i = tmp;
			j = i;
		}
		return i + random.nextInt((j - i) + 1);
	}

	/**
	 * 得到当前系统日期
	 * 
	 * @return 当前日期的格式字符串,日期格式为"yyyy-MM-dd"
	 */
	public static String getCurrentDate() {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		Date today = new Date();
		String tString = df.format(today);
		return tString;
	}

	/**
	 * 得到当前系统时间
	 * 
	 * @return 当前时间的格式字符串，时间格式为"HH:mm:ss"
	 */
	public static String getCurrentTime() {
		String pattern = "HH:mm:ss";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		Date today = new Date();
		String tString = df.format(today);
		return tString;
	}

	/**
	 * 保留小数点后两位
	 * 
	 * @param value
	 * @return
	 */
	public static float point2(double value) {
		DecimalFormat df = new DecimalFormat("#.00");
		return Float.parseFloat(df.format(value));
	}
}
