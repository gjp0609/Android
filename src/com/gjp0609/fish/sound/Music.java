package com.gjp0609.fish.sound;

import android.media.MediaPlayer;

import com.gjp0609.fish.frame.base.BaseActivity;

public class Music {

	// 设置音乐开关的变量
	private static boolean isMusicOn;
	// MediaPlayer对象
	private static MediaPlayer mediaPlayer;
	// 音乐资源的ID
	private static int resId;

	// 提供公共的访问私有对象的方法
	// 设置将要播放的音乐的资源id
	public static void initMusic(int resId) {
		Music.resId = resId;
	}

	// 得到音乐的开关状态
	public static boolean isNusicOn() {
		return isMusicOn;
	}

	// 设置音乐的开关状态
	public static void setMusicOnOff(boolean isOn) {
		isMusicOn = isOn;
	}

	// 播放音乐
	public static void playMusic() {
		// 如果音乐开关是关闭状态，不播放，直接退出
		if (!isMusicOn)
			return;
		// 如果用户没有初始化音乐资源id,直接退出
		if (resId == 0)
			return;
		// 如果音乐是正在播放中，则先停止，再重置，再清空
		if (mediaPlayer != null) {
			if (mediaPlayer.isPlaying())
				mediaPlayer.stop();
			mediaPlayer.reset();
			mediaPlayer = null;
		}

		// 进行音乐播放
		mediaPlayer = MediaPlayer.create(BaseActivity.currentActivity, resId);
		mediaPlayer.setLooping(true);
		mediaPlayer.start();
	}

	// 停止音乐
	public static void stop() {
		if (mediaPlayer != null) {
			if (mediaPlayer.isPlaying())
				mediaPlayer.stop();
			mediaPlayer.release();
			mediaPlayer = null;
		}
	}
}
