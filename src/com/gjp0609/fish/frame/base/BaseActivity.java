package com.gjp0609.fish.frame.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class BaseActivity extends Activity {
	public static Activity currentActivity;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		currentActivity = this;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		currentActivity = this;
		return super.onCreateOptionsMenu(menu);

	}
}
