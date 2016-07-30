package com.gjp0609.fish.frame.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
/**
 * ���� ������
 * @author zar
 */
public class CommonUtil {

	private static final Random random = new Random();

	/**
	 * ����һ�������
	 * @param i
	 * @param j
	 * @return �����
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
	 * �õ���ǰϵͳ����
	 * 
	 * @return ��ǰ���ڵĸ�ʽ�ַ���,���ڸ�ʽΪ"yyyy-MM-dd"
	 */
	public static String getCurrentDate() {
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		Date today = new Date();
		String tString = df.format(today);
		return tString;
	}

	/**
	 * �õ���ǰϵͳʱ��
	 * 
	 * @return ��ǰʱ��ĸ�ʽ�ַ�����ʱ���ʽΪ"HH:mm:ss"
	 */
	public static String getCurrentTime() {
		String pattern = "HH:mm:ss";
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		Date today = new Date();
		String tString = df.format(today);
		return tString;
	}

	/**
	 * ����С�������λ
	 * 
	 * @param value
	 * @return
	 */
	public static float point2(double value) {
		DecimalFormat df = new DecimalFormat("#.00");
		return Float.parseFloat(df.format(value));
	}
}
