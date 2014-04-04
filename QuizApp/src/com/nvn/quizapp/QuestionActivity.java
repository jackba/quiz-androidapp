package com.nvn.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;

public class QuestionActivity extends BaseActivity implements OnClickListener {
	private Button mBtnPause, mBtnEnd;
	private SeekBar mSbNumberQuestion, mSbTimeAudio;
	int oldProgressNumberQuestion, oldProgressTimeAudio;
	private CountDownTimer mCountDownTimer;
	private final long startTime = 30 * 1000;
	private final long interval = 1 * 1000;
	private TextView mTvTimer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_question);
		initViews();
		initProperties();
		initListeners();
	}

	@Override
	public void initViews() {
		mBtnPause = (Button) findViewById(R.id.btn_pause);
		mBtnEnd = (Button) findViewById(R.id.btn_end);
		mSbNumberQuestion = (SeekBar) findViewById(R.id.sb_number_question);
		mSbTimeAudio = (SeekBar) findViewById(R.id.sb_time_audio);
		mTvTimer = (TextView) findViewById(R.id.tv_timer);
	}

	@Override
	public void initListeners() {
		mBtnPause.setOnClickListener(this);
		mBtnEnd.setOnClickListener(this);
		mSbNumberQuestion
				.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

					@Override
					public void onStopTrackingTouch(SeekBar seekBar) {
						seekBar.setProgress(oldProgressNumberQuestion);
					}

					@Override
					public void onStartTrackingTouch(SeekBar seekBar) {
						oldProgressNumberQuestion = seekBar.getProgress();
						seekBar.setProgress(oldProgressNumberQuestion);
					}

					@Override
					public void onProgressChanged(SeekBar seekBar,
							int progress, boolean fromUser) {
						seekBar.setProgress(oldProgressNumberQuestion);
					}
				});
		mSbTimeAudio.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				seekBar.setProgress(oldProgressTimeAudio);
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				oldProgressTimeAudio = seekBar.getProgress();
				seekBar.setProgress(oldProgressTimeAudio);
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				seekBar.setProgress(oldProgressTimeAudio);
			}
		});
	}

	@Override
	public void initProperties() {
		mCountDownTimer = new MyCountTimer(startTime, interval);
		mCountDownTimer.start();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_pause:
			startActivity(new Intent(QuestionActivity.this, PauseActivity.class));
			break;
		case R.id.btn_end:
			startActivity(new Intent(QuestionActivity.this,
					CompletedActivity.class));
			break;
		default:
			break;
		}
	}

	public class MyCountTimer extends CountDownTimer {

		public MyCountTimer(long startTime, long interval) {
			super(startTime, interval);
		}

		@Override
		public void onFinish() {
			// TODO Auto-generated method stub

		}

		@Override
		public void onTick(long millisUntilFinished) {
			mTvTimer.setText((millisUntilFinished / 1000) / 60 + ":"
					+ (millisUntilFinished / 1000) % 60);
		}

	}
}
