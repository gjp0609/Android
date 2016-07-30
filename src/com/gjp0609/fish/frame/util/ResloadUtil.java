package com.gjp0609.fish.frame.util;

import java.io.IOException;
import java.io.InputStream;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;

import com.gjp0609.fish.frame.base.BaseActivity;

/**
 * ��Դ���� ������,��Ҫʵ�ֶ�ͼ����Դ������ļ���
 * 
 * @author zar
 */
public class ResloadUtil {

	/**
	 * ��Assets�л�ȡ����ttf
	 * 
	 * @param fileName
	 * @return
	 */
	public final static Typeface getFontFromAssets(String fileName) {
		Typeface typeface = Typeface.createFromAsset(
				getResources().getAssets(), fileName);
		return typeface;
	}

	/**
	 * ��res�ļ��л�ȡͼ��
	 * 
	 * @param id
	 *            ͼ����Դ��id��(�磺R.drawable.logo)
	 * @return
	 */
	public final static Bitmap getBitmapFromRes(int id) {
		Bitmap image = BitmapFactory.decodeResource(getResources(), id);
		return image;
	}

	/**
	 * ��assets�ļ��л�ȡͼ��
	 * 
	 * @param fileName
	 *            assets�ļ������ļ�����(�磺logo.png)
	 * @return
	 */
	public final static Bitmap getBitmapFromAssets(String fileName) {
		Bitmap image = null;
		fileName = "graphics/" + fileName;
		AssetManager am = getResources().getAssets();
		try {
			InputStream is = am.open(fileName);
			image = BitmapFactory.decodeStream(is);
			is.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return image;
	}

	/**
	 * ������Ե�ǰ��ϷӦ�õ���Դ������
	 * 
	 * @return
	 */
	public final static android.content.res.Resources getResources() {
		return BaseActivity.currentActivity.getResources();
	}
}
