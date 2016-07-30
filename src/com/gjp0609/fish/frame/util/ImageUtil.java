package com.gjp0609.fish.frame.util;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;

/**
 * ͼƬ���� ������
 * @author zar
 */
public class ImageUtil {

	/**
	 * ͼƬȥɫ,���ػҶ�ͼƬ
	 * @param bmpOriginal �����ͼƬ
	 * @return ȥɫ���ͼƬ
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
	 * ���ͼƬ
	 * @param bitmap
	 * @param xPiece X���м���ͼƬ
	 * @param yPiece Y���м���ͼƬ
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
	 * ͼƬ����
	 * @param bitmap
	 * @param wRate ������ű���
	 * @param hRate �߶����ű���
	 * @return
	 */
	public static Bitmap zoom(Bitmap bitmap, float wRate, float hRate) {
		Matrix matrix = new Matrix();
		matrix.postScale(wRate, hRate); // ���Ϳ�Ŵ���С�ı���
		Bitmap resizeBmp = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
		return resizeBmp;
	}

	/**
	 * ͼƬ����
	 * @param oldimg
	 * @param newWidth ���ź���
	 * @param newHeight ���ź�߶�
	 * @return
	 */
	public static Bitmap zoom(Bitmap oldimg, int newWidth, int newHeight) {
		Matrix matrix = new Matrix();
		// ��ȡ���ͼƬ�Ŀ�͸�
		int width = oldimg.getWidth();
		int height = oldimg.getHeight();
		// ��������ͼƬ�õ�matrix����
		matrix.reset();
		// ���������ʣ��³ߴ��ԭʼ�ߴ�
		float scaleWidth = ((float) newWidth) / width;
		float scaleHeight = ((float) newHeight) / height;
		// ����ͼƬ����
		matrix.postScale(scaleWidth, scaleHeight);
		Bitmap bitmap = Bitmap.createBitmap(oldimg, 0, 0, width, height, matrix, true);
		return bitmap;
	}

	/**
	 * ͼƬ��ת
	 * @param b
	 * @param degrees ��ת�Ƕ�
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
				// ��������γ������ڴ治���쳣�����return ԭʼ��bitmap����.
			}

		}
		return b;
	}

	/**
	 * ͼƬ��ת
	 * @param b
	 * @param degrees ��ת�Ƕ�
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
	 * ͼƬ����
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