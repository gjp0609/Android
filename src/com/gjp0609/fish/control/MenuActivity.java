package com.gjp0609.fish.control;

import com.gjp0609.fish.R;
import com.gjp0609.fish.frame.base.BaseActivity;
import com.gjp0609.fish.sound.Music;
import com.gjp0609.fish.sound.Sound;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuActivity extends BaseActivity {

	private TextView btn_menu_start, btn_menu_score, btn_menu_setting;
	private ImageView iv_logo;
	private AlertDialog dialog;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_menu);
		btn_menu_start = (TextView) this.findViewById(R.id.menu_start);
		btn_menu_score = (TextView) this.findViewById(R.id.menu_score);
		btn_menu_setting = (TextView) this.findViewById(R.id.menu_setting);
		iv_logo = (ImageView) this.findViewById(R.id.menu_logo);
		init();
		initDialog();
	}

	void init() {
		// 读取偏好设置
		SharedPreferences preferences = getSharedPreferences("duckset",
				MODE_PRIVATE);
		SettingActivity.isMusicOn = preferences.getBoolean("music", true);
		SettingActivity.isSoundOn = preferences.getBoolean("sound", true);
		SettingActivity.isVibrate = preferences.getBoolean("vibrate", true);
		SettingActivity.playMode = preferences.getInt("mode",
				SettingActivity.PLAY_MODE_TOUCH);
		// 实现背景音乐
		Music.setMusicOnOff(SettingActivity.isMusicOn);
		Music.initMusic(R.raw.music_1);
		Music.playMusic();
		// 初始化音效
		int[] sounds = { R.raw.bgm_fire, R.raw.bgm_coin_01,
				R.raw.bgm_change_cannon };
		Sound.initSound(sounds.length, sounds);

		View.OnClickListener ocl = new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent_main = new Intent();
				switch (v.getId()) {
				case R.id.menu_start:
					intent_main.setClass(MenuActivity.this, GameActivity.class);
					break;
				case R.id.menu_score:
					intent_main
							.setClass(MenuActivity.this, ScoreActivity.class);
					break;
				case R.id.menu_setting:
					intent_main.setClass(MenuActivity.this,
							SettingActivity.class);
					break;
				default:
					break;
				}
				startActivity(intent_main);
			}
		};
		btn_menu_start.setOnClickListener(ocl);
		btn_menu_score.setOnClickListener(ocl);
		btn_menu_setting.setOnClickListener(ocl);
		Animation anim_menu_logo = AnimationUtils.loadAnimation(
				MenuActivity.this, R.anim.anim_menu_logo);
		iv_logo.setAnimation(anim_menu_logo);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			dialog.show();
		}
		return super.onKeyDown(keyCode, event);
	}

	private void initDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setIcon(getResources().getDrawable(R.drawable.ic_launcher));
		builder.setTitle("Duck");
		builder.setMessage("Are you sure to exit?");
		builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				if (which == -1)
					MenuActivity.this.finish();
			}
		});
		builder.setNegativeButton("Cancel", null);
		dialog = builder.create();

	}
}
