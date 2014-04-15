package com.nvn.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class PauseActivity extends BaseActivity implements OnClickListener {
	private SeekBar mSbPause;
	int oldProgressPause;
	private Button mBtnResume;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pause);
		initViews();
		initProperties();
		initListeners();
	}

	@Override
	public void initViews() {
		mSbPause = (SeekBar) findViewById(R.id.sb_pause);
		mBtnResume = (Button) findViewById(R.id.btn_resume);
	}

	@Override
	public void initListeners() {
		mSbPause.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				seekBar.setProgress(oldProgressPause);
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				oldProgressPause = seekBar.getProgress();
				seekBar.setProgress(oldProgressPause);
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				seekBar.setProgress(oldProgressPause);
			}
		});
		mBtnResume.setOnClickListener(this);
		Intent callerIntent = getIntent();
		Bundle packageFromCaller = callerIntent.getBundleExtra("MyPackage");
		long a = packageFromCaller.getLong("soa");

//		Toast.makeText(this, "Number " + a, Toast.LENGTH_LONG).show();
		callerIntent.putExtra("data", a);
		setResult(123, callerIntent);
	}

	@Override
	public void initProperties() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_resume:
			finish();// finishing activity
			break;

		default:
			break;
		}
	}

}
