package com.gjp0609.fish.frame.util;

import android.app.Service;
import android.content.Context;
import android.os.Vibrator;
import android.view.WindowManager;

import com.gjp0609.fish.frame.base.BaseActivity;

/**
 * 设备 工具类,封装了一些对设备上的常用操作
 * 
 * @author zar
 */
public class DeviceUtil {

	/**
	 * 震动
	 * 
	 * @param milliseconds
	 *            震动强度
	 * @see 权限 <uses-permission android:name="android.permission.VIBRATE" >
	 *      </uses-permission>
	 */
	public static void vibrate(long milliseconds) {
		Vibrator vib = (Vibrator) BaseActivity.currentActivity
				.getSystemService(Service.VIBRATOR_SERVICE);
		vib.vibrate(milliseconds);
	}

	/**
	 * 得到屏幕的宽
	 * 
	 * @param context
	 * @return 屏幕宽
	 */
	public static int getScreenWidth() {
		WindowManager mWindowManager = (WindowManager) BaseActivity.currentActivity
				.getSystemService(Context.WINDOW_SERVICE);
		return mWindowManager.getDefaultDisplay().getWidth();
	}

	/**
	 * 得到屏幕的高
	 * 
	 * @param context
	 * @return 屏幕高
	 */
	public static int getScreenHeight() {
		WindowManager mWindowManager = (WindowManager) BaseActivity.currentActivity
				.getSystemService(Context.WINDOW_SERVICE);
		return mWindowManager.getDefaultDisplay().getHeight();
	}

	/**
	 * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
	 */
	public static int dip2px(float dpValue) {
		final float scale = BaseActivity.currentActivity.getResources()
				.getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/**
	 * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
	 */
	public static int px2dip(float pxValue) {
		final float scale = BaseActivity.currentActivity.getResources()
				.getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}
}
