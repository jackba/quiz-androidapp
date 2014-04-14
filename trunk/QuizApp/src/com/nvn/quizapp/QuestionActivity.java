package com.nvn.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.nvn.quizapp.fragments.questiontype.MovieQuestionFragment;

public class QuestionActivity extends BaseFragmentActivity implements
		OnClickListener {
	private Button mBtnPause;
	private SeekBar mSbNumberQuestion;
	int oldProgressNumberQuestion, oldProgressTimeAudio;
	private CountDownTimer mCountDownTimer;
	private final long startTime = 30 * 1000;
	private final long interval = 1 * 1000;
	private TextView mTvTimer;
	int i = 0;
	private long mCurrentTime;

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
		mSbNumberQuestion = (SeekBar) findViewById(R.id.sb_number_question);
		mTvTimer = (TextView) findViewById(R.id.tv_timer);
	}

	@Override
	public void initListeners() {
		mBtnPause.setOnClickListener(this);
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
	}

	@Override
	public void initProperties() {
		setNewPage(new MovieQuestionFragment());
		mCountDownTimer = new MyCountTimer(startTime, interval);
		mCountDownTimer.start();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_pause:
			// startActivity(new Intent(QuestionActivity.this,
			// PauseActivity.class));
			Intent intent = new Intent(QuestionActivity.this,
					PauseActivity.class);
			intent.putExtra("TIME_CURRENT", "1000");
			startActivityForResult(intent, 2);
			break;
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		// check if the request code is same as what is passed here it is 2
		if (requestCode == 2) {
			String time = data.getStringExtra("TIME");
			Toast.makeText(this, "hien thi thoi gian: " + time,
					Toast.LENGTH_LONG).show();
			// long i = Long.parseLong(time);
			// mCountDownTimer = new MyCountTimer(i, interval);
			// mCountDownTimer.start();
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
			mCurrentTime = millisUntilFinished;
		}

	}

	public void setNewPage(Fragment fragment) {
		while (getSupportFragmentManager().getBackStackEntryCount() > 0) {
			getSupportFragmentManager().popBackStackImmediate();
		}
		try {
			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.content_fragment, fragment, "currentFragment")
					.commitAllowingStateLoss();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
