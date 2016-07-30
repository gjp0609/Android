package com.gjp0609.fish.sound;

import com.gjp0609.fish.frame.base.BaseActivity;

import android.media.AudioManager;
import android.media.SoundPool;

public class Sound {
	// ��Ч����
	private static boolean isSoundOn;
	// ������Ч�Ķ���
	private static SoundPool soundPool;
	// ���ŵ���Ч��Դ
	private static int[] soundIds;

	// ��ȡ��Ч����״̬
	public static boolean isSoundOn() {
		return isSoundOn;
	}

	// ������Ч����״̬
	public static void setSoundOnOff(boolean isOn) {
		isSoundOn = isOn;
	}

	// ��ʼ����Ч
	public static void initSound(int maxNum, int[] resIds) {
		soundPool = new SoundPool(maxNum, AudioManager.STREAM_MUSIC, 0);
		// ��ΪSoundPoolֻ�ܲ��ųػ��������Խ���ת��
		soundIds = new int[resIds.length];
		for (int i = 0; i < resIds.length; i++) {
			soundIds[i] = soundPool.load(BaseActivity.currentActivity,
					resIds[i], 1);
		}
	}

	// ������Ч
	public static void PlaySound(int index) {
		if (!isSoundOn) {
			return;
		}
		if (soundPool == null)
			return;
		if (isSoundOn) {
			soundPool.play(soundIds[index], 1.0f, 1.0f, 0, 0, 1.0f);
		}
	}
}
