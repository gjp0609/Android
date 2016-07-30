package com.gjp0609.fish.sound;

import com.gjp0609.fish.frame.base.BaseActivity;

import android.media.AudioManager;
import android.media.SoundPool;

public class Sound {
	// 音效开关
	private static boolean isSoundOn;
	// 播放音效的对象
	private static SoundPool soundPool;
	// 播放的音效资源
	private static int[] soundIds;

	// 获取音效开关状态
	public static boolean isSoundOn() {
		return isSoundOn;
	}

	// 设置音效开关状态
	public static void setSoundOnOff(boolean isOn) {
		isSoundOn = isOn;
	}

	// 初始化音效
	public static void initSound(int maxNum, int[] resIds) {
		soundPool = new SoundPool(maxNum, AudioManager.STREAM_MUSIC, 0);
		// 因为SoundPool只能播放池化对象，所以进行转化
		soundIds = new int[resIds.length];
		for (int i = 0; i < resIds.length; i++) {
			soundIds[i] = soundPool.load(BaseActivity.currentActivity,
					resIds[i], 1);
		}
	}

	// 播放音效
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
