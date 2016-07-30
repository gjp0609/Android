package com.gjp0609.fish.frame.util;
/**
 * ��ײ ������
 * @author zar
 */
public class CollideUtil {

	/**
	 * �ж�Բ�;����Ƿ���ײ
	 * @param arcX Բ��x
	 * @param arcY Բ��y
	 * @param arcR Բ�ΰ뾶
	 * @param rectX ����x
	 * @param rectY ����y
	 * @param rectW ���ο��
	 * @param rectH ���θ߶�
	 * @return trueΪ��ײ,falseΪδ��ײ
	 */
	public static final boolean isArcRectCollides(int arcX, int arcY, int arcR, int rectX, int rectY, int rectW, int rectH) {
		// �ֱ��жϾ���4��������Բ�ĵľ����Ƿ�<=Բ�뾶�����<=��˵����ײ�ɹ�
		int arcD = arcR << 1;
		if (arcX + arcD < rectX ||arcX > rectX + rectW || arcY + arcD < rectY || arcY > rectY + rectH)
			return false;
		int arcOx = arcX + arcR; // Բ��X����
		int arcOy = arcY + arcR; // Բ��Y����
		int minDis = rectW + rectH + 2 * arcR;

		// �жϵ�Բ�ĵ�X������������ʱY��λ�ã����X��(rectY-arcR)��(rectY+rectH+arcR)�����Χ�ڣ�����ײ�ɹ�
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

		// �жϵ�Բ�ĵ�Y������������ʱX��λ�ã����X��(rectX-arcR)��(rectX+rectW+arcR)�����Χ�ڣ�����ײ�ɹ�
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
