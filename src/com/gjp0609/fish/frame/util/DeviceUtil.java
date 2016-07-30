package com.gjp0609.fish.frame.util;

import android.app.Service;
import android.content.Context;
import android.os.Vibrator;
import android.view.WindowManager;

import com.gjp0609.fish.frame.base.BaseActivity;

/**
 * �豸 ������,��װ��һЩ���豸�ϵĳ��ò���
 * 
 * @author zar
 */
public class DeviceUtil {

	/**
	 * ��
	 * 
	 * @param milliseconds
	 *            ��ǿ��
	 * @see Ȩ�� <uses-permission android:name="android.permission.VIBRATE" >
	 *      </uses-permission>
	 */
	public static void vibrate(long milliseconds) {
		Vibrator vib = (Vibrator) BaseActivity.currentActivity
				.getSystemService(Service.VIBRATOR_SERVICE);
		vib.vibrate(milliseconds);
	}

	/**
	 * �õ���Ļ�Ŀ�
	 * 
	 * @param context
	 * @return ��Ļ��
	 */
	public static int getScreenWidth() {
		WindowManager mWindowManager = (WindowManager) BaseActivity.currentActivity
				.getSystemService(Context.WINDOW_SERVICE);
		return mWindowManager.getDefaultDisplay().getWidth();
	}

	/**
	 * �õ���Ļ�ĸ�
	 * 
	 * @param context
	 * @return ��Ļ��
	 */
	public static int getScreenHeight() {
		WindowManager mWindowManager = (WindowManager) BaseActivity.currentActivity
				.getSystemService(Context.WINDOW_SERVICE);
		return mWindowManager.getDefaultDisplay().getHeight();
	}

	/**
	 * �����ֻ��ķֱ��ʴ� dp �ĵ�λ ת��Ϊ px(����)
	 */
	public static int dip2px(float dpValue) {
		final float scale = BaseActivity.currentActivity.getResources()
				.getDisplayMetrics().density;
		return (int) (dpValue * scale + 0.5f);
	}

	/**
	 * �����ֻ��ķֱ��ʴ� px(����) �ĵ�λ ת��Ϊ dp
	 */
	public static int px2dip(float pxValue) {
		final float scale = BaseActivity.currentActivity.getResources()
				.getDisplayMetrics().density;
		return (int) (pxValue / scale + 0.5f);
	}
}
