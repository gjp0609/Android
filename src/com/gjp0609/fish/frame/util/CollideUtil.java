package com.gjp0609.fish.frame.util;
/**
 * 碰撞 工具类
 * @author zar
 */
public class CollideUtil {

	/**
	 * 判断圆和矩形是否碰撞
	 * @param arcX 圆形x
	 * @param arcY 圆形y
	 * @param arcR 圆形半径
	 * @param rectX 矩形x
	 * @param rectY 矩形y
	 * @param rectW 矩形宽度
	 * @param rectH 矩形高度
	 * @return true为碰撞,false为未碰撞
	 */
	public static final boolean isArcRectCollides(int arcX, int arcY, int arcR, int rectX, int rectY, int rectW, int rectH) {
		// 分别判断矩形4个顶点与圆心的距离是否<=圆半径；如果<=，说明碰撞成功
		int arcD = arcR << 1;
		if (arcX + arcD < rectX ||arcX > rectX + rectW || arcY + arcD < rectY || arcY > rectY + rectH)
			return false;
		int arcOx = arcX + arcR; // 圆心X坐标
		int arcOy = arcY + arcR; // 圆心Y坐标
		int minDis = rectW + rectH + 2 * arcR;

		// 判断当圆心的X坐标进入矩形内时Y的位置，如果X在(rectY-arcR)到(rectY+rectH+arcR)这个范围内，则碰撞成功
		int minDisY = 0;
		if (arcOx >= rectX && arcOx <= rectX + rectW) {
			if (arcOy < rectY)
				minDisY = rectY - arcOy;
			else if (arcOy > rectY + rectH)
				minDisY = arcOy - rectY - rectH;
			else
				return true;
			minDis = min(minDis, minDisY);
		}

		// 判断当圆心的Y坐标进入矩形内时X的位置，如果X在(rectX-arcR)到(rectX+rectW+arcR)这个范围内，则碰撞成功
		int minDisX = 0;
		if (arcOy >= rectY && arcOy <= rectY + rectH) {
			if (arcOx < rectX)
				minDisX = rectX - arcOx;
			else if (arcOx > rectX + rectW)
				minDisX = arcOx - rectX - rectW;
			else
				return true;
			minDis = min(minDis, minDisX);
		}

		minDis *= minDis;
		minDis = min(minDis, getMHD(rectX, rectY, arcOx, arcOy));
		minDis = min(minDis, getMHD(rectX + rectW, rectY, arcOx, arcOy));
		minDis = min(minDis, getMHD(rectX, rectY + rectH, arcOx, arcOy));
		minDis = min(minDis, getMHD(rectX + rectW, rectY + rectH, arcOx, arcOy));
		return minDis <= arcR * arcR;
	}

	private static final int min(int x, int y) {
		return x > y ? y : x;
	}

	private static final int getMHD(int x0, int y0, int x1, int y1) {
		return (x0 - x1) * (x0 - x1) + (y0 - y1) * (y0 - y1);
	}
}
