package com.gjp0609.fish.frame.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;

/**
 * 图片处理 工具类
 * @author zar
 */
public class ImageUtil {

	/**
	 * 图片去色,返回灰度图片
	 * @param bmpOriginal 传入的图片
	 * @return 去色后的图片
	 */
	public static Bitmap toGrayscale(Bitmap bmpOriginal) {
		int width, height;
		height = bmpOriginal.getHeight();
		width = bmpOriginal.getWidth();

		Bitmap bmpGrayscale = Bitmap.createBitmap(width, height, Bitmap.Config.RGB_565);
		Canvas c = new Canvas(bmpGrayscale);
		Paint paint = new Paint();
		ColorMatrix cm = new ColorMatrix();
		cm.setSaturation(0);
		ColorMatrixColorFilter f = new ColorMatrixColorFilter(cm);
		paint.setColorFilter(f);
		c.drawBitmap(bmpOriginal, 0, 0, paint);
		return bmpGrayscale;
	}

	/**
	 * 拆分图片
	 * @param bitmap
	 * @param xPiece X轴有几个图片
	 * @param yPiece Y轴有几个图片
	 * @return
	 */
	public static Bitmap[] split(Bitmap bitmap, int xPiece, int yPiece) {
		Bitmap[] pieces = new Bitmap[xPiece * yPiece];
		int width = bitmap.getWidth();
		int height = bitmap.getHeight();
		int pieceWidth = width / xPiece;
		int pieceHeight = height / yPiece;
		int index = 0;
		for (int i = 0; i < yPiece; i++) {
			for (int j = 0; j < xPiece; j++) {
				int xValue = j * pieceWidth;
				int yValue = i * pieceHeight;
				pieces[index] = Bitmap.createBitmap(bitmap, xValue, yValue, pieceWidth, pieceHeight);
				index++;
			}
		}
		return pieces;
	}

	/**
	 * 图片缩放
	 * @param bitmap
	 * @param wRate 宽度缩放比例
	 * @param hRate 高度缩放比例
	 * @return
	 */
	public static Bitmap zoom(Bitmap bitmap, float wRate, float hRate) {
		Matrix matrix = new Matrix();
		matrix.postScale(wRate, hRate); // 长和宽放大缩小的比例
		Bitmap resizeBmp = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
		return resizeBmp;
	}

	/**
	 * 图片缩放
	 * @param oldimg
	 * @param newWidth 缩放后宽度
	 * @param newHeight 缩放后高度
	 * @return
	 */
	public static Bitmap zoom(Bitmap oldimg, int newWidth, int newHeight) {
		Matrix matrix = new Matrix();
		// 获取这个图片的宽和高
		int width = oldimg.getWidth();
		int height = oldimg.getHeight();
		// 创建操作图片用的matrix对象
		matrix.reset();
		// 计算缩放率，新尺寸除原始尺寸
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;
		// 缩放图片动作
		matrix.postScale(scaleWidth, scaleHeight);
		Bitmap bitmap = Bitmap.createBitmap(oldimg, 0, 0, width, height, matrix, true);
		return bitmap;
	}

	/**
	 * 图片旋转
	 * @param b
	 * @param degrees 旋转角度
	 * @return
	 */
	public static Bitmap bitmapRotate(Bitmap b, int degrees) {
		if (degrees != 0 && b != null) {
			Matrix m = new Matrix();
			m.setRotate(degrees, (float) b.getWidth() / 2, (float) b.getHeight() / 2);
			try {
				Bitmap b2 = Bitmap.createBitmap(b, 0, 0, b.getWidth(), b.getHeight(), m, true);
				if (b != b2) {
					b = b2;
				}
			} catch (OutOfMemoryError ex) {
				// 建议大家如何出现了内存不足异常，最好return 原始的bitmap对象。.
			}

		}
		return b;
	}

	/**
	 * 图片旋转
	 * @param b
	 * @param degrees 旋转角度
	 * @return
	 */
	public static Bitmap rotate(Bitmap bit, float degrees) {
		if (bit == null) {
			return bit;
		}
		if (degrees % 360 != 0) {
			int width = bit.getWidth();
			int height = bit.getHeight();
			int nx = width / 2;
			int ny = height / 2;

			Matrix matrix = new Matrix();
			matrix.reset();
			matrix.preTranslate(-nx, -ny);
			matrix.postRotate(degrees);
			matrix.postTranslate(nx, ny);

			Bitmap dst = Bitmap.createBitmap(bit, 0, 0, width, height, matrix, false);
			return dst;

		} else {
			return bit;
		}
	}

	/**
	 * 图片镜像
	 * @param bitmap
	 * @return
	 */
	public static final Bitmap mirror(Bitmap bitmap) {
		Matrix mMatrix = new Matrix();
		float[] mirrorY = { -1, 0, 0, 0, 1, 0, 0, 0, 1 };
		mMatrix.setValues(mirrorY);
		bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), mMatrix, true);
		return bitmap;
	}
}