package com.nvn.quizapp;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class PauseActivity extends BaseActivity {
	private SeekBar mSbPause;
	int oldProgressPause;

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
	}

	@Override
	public void initProperties() {
		// TODO Auto-generated method stub

	}

}
