package com.gjp0609.fish.control;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnMultiChoiceClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.gjp0609.fish.R;
import com.gjp0609.fish.frame.base.BaseActivity;
import com.gjp0609.fish.sound.Music;

public class SettingActivity extends BaseActivity {

	// ������¼����״̬��һЩ����
	public static boolean isMusicOn;
	public static boolean isSoundOn;
	public static boolean isVibrate;
	public static int playMode;

	public static final int PLAY_MODE_TOUCH = 1;
	public static final int PLAY_MODE_SENSOR = 0;

	private TextView button_music, button_mode;
	private AlertDialog dialog_music, dialog_mode;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);

		button_music = (TextView) this.findViewById(R.id.setting_button_music);
		button_mode = (TextView) this.findViewById(R.id.setting_button_mode);

		button_music.setOnClickListener(myBtnClickListener);
		button_mode.setOnClickListener(myBtnClickListener);

		initDialog();

	}

	private View.OnClickListener myBtnClickListener = new View.OnClickListener() {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.setting_button_music:
				dialog_music.show();
				break;
			case R.id.setting_button_mode:
				dialog_mode.show();
				break;

			}
		}
	};

	private void initDialog() {
		AlertDialog.Builder builder1 = new AlertDialog.Builder(this);
		builder1.setIcon(R.drawable.ic_launcher);
		builder1.setTitle("��������");
		String[] items1 = { "��������", "��Ч����", "������" };
		boolean[] checkedItems = { isMusicOn, isSoundOn, isVibrate };
		builder1.setMultiChoiceItems(items1, checkedItems, listener_music);
		builder1.setPositiveButton("�ر�", null);
		dialog_music = builder1.create();

		AlertDialog.Builder builder2 = new AlertDialog.Builder(this);
		builder2.setIcon(R.drawable.ic_launcher);
		builder2.setTitle("��Ϸ����");
		String[] items2 = { "������Ӧģʽ", "�������ģʽ" };

		builder2.setSingleChoiceItems(items2, playMode, listener_mode);
		builder2.setPositiveButton("�ر�", null);
		dialog_mode = builder2.create();
	}

	private DialogInterface.OnMultiChoiceClickListener listener_music = new OnMultiChoiceClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which, boolean isChecked) {
			switch (which) {
			case 0:
				isMusicOn = isChecked;
				break;
			case 1:
				isSoundOn = isChecked;
				break;
			case 2:
				isVibrate = isChecked;
				break;
			}

			// ���ݵ�ǰ�û���ѡ�����������Ŀ���
			Music.setMusicOnOff(isMusicOn);
			if (isMusicOn)
				Music.playMusic();
			else
				Music.stop();

			saveSetting();
		}
	};

	private DialogInterface.OnClickListener listener_mode = new DialogInterface.OnClickListener() {
		@Override
		public void onClick(DialogInterface dialog, int which) {
			playMode = which;
			saveSetting();
		}
	};

	private void saveSetting() {
		SharedPreferences preferences = getSharedPreferences("duckset",
				MODE_PRIVATE);
		Editor editor = preferences.edit();
		editor.putBoolean("music", isMusicOn);
		editor.putBoolean("sound", isSoundOn);
		editor.putBoolean("vibrate", isVibrate);
		editor.putInt("mode", playMode);
		editor.commit();
	}
}
