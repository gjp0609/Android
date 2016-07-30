package com.gjp0609.fish.sound;

import android.media.MediaPlayer;

import com.gjp0609.fish.frame.base.BaseActivity;

public class Music {

	// �������ֿ��صı���
	private static boolean isMusicOn;
	// MediaPlayer����
	private static MediaPlayer mediaPlayer;
	// ������Դ��ID
	private static int resId;

	// �ṩ�����ķ���˽�ж���ķ���
	// ���ý�Ҫ���ŵ����ֵ���Դid
	public static void initMusic(int resId) {
		Music.resId = resId;
	}

	// �õ����ֵĿ���״̬
	public static boolean isNusicOn() {
		return isMusicOn;
	}

	// �������ֵĿ���״̬
	public static void setMusicOnOff(boolean isOn) {
		isMusicOn = isOn;
	}

	// ��������
	public static void playMusic() {
		// ������ֿ����ǹر�״̬�������ţ�ֱ���˳�
		if (!isMusicOn)
			return;
		// ����û�û�г�ʼ��������Դid,ֱ���˳�
		if (resId == 0)
			return;
		// ������������ڲ����У�����ֹͣ�������ã������
		if (mediaPlayer != null) {
			if (mediaPlayer.isPlaying())
				mediaPlayer.stop();
			mediaPlayer.reset();
			mediaPlayer = null;
		}

		// �������ֲ���
		mediaPlayer = MediaPlayer.create(BaseActivity.currentActivity, resId);
		mediaPlayer.setLooping(true);
		mediaPlayer.start();
	}

	// ֹͣ����
	public static void stop() {
		if (mediaPlayer != null) {
			if (mediaPlayer.isPlaying())
				mediaPlayer.stop();
			mediaPlayer.release();
			mediaPlayer = null;
		}
	}
}
