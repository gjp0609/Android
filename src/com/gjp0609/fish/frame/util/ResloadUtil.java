package com.gjp0609.fish.frame.util;

import java.io.IOException;
import java.io.InputStream;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Typeface;

import com.gjp0609.fish.frame.base.BaseActivity;

/**
 * 资源加载 工具类,主要实现对图像资源、字体的加载
 * 
 * @author zar
 */
public class ResloadUtil {

	/**
	 * 从Assets中获取字体ttf
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
	 * 从res文件中获取图像
	 * 
	 * @param id
	 *            图像资源的id号(如：R.drawable.logo)
	 * @return
	 */
	public final static Bitmap getBitmapFromRes(int id) {
		Bitmap image = BitmapFactory.decodeResource(getResources(), id);
		return image;
	}

	/**
	 * 从assets文件中获取图像
	 * 
	 * @param fileName
	 *            assets文件夹下文件名称(如：logo.png)
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
	 * 返回针对当前游戏应用的资源管理器
	 * 
	 * @return
	 */
	public final static android.content.res.Resources getResources() {
		return BaseActivity.currentActivity.getResources();
	}
}
