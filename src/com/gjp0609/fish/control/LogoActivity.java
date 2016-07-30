package com.gjp0609.fish.control;

import com.gjp0609.fish.R;
import com.gjp0609.fish.frame.base.BaseActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class LogoActivity extends BaseActivity {
	ImageView iv_logo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_logo);
		iv_logo = (ImageView) this.findViewById(R.id.imageView_logo_anim);
		init();
	}

	void init() {
		Animation anim_logo = AnimationUtils.loadAnimation(this,
				R.anim.anim_logo);
		iv_logo.setAnimation(anim_logo);
		anim_logo.setAnimationListener(new AnimationListener() {
			@Override
			public void onAnimationStart(Animation animation) {
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				Intent intent_logo = new Intent(LogoActivity.this,
						MenuActivity.class);
				startActivity(intent_logo);
				overridePendingTransition(R.anim.anim_activity_change2,
						R.anim.anim_activity_change);
				LogoActivity.this.finish();
			}
		});
	}
}
