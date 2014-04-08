package com.nvn.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.VideoView;

public class QuestionActivity extends BaseActivity implements OnClickListener {
	private Button mBtnPause, mBtnEnd;
	private SeekBar mSbNumberQuestion, mSbTimeAudio;
	int oldProgressNumberQuestion, oldProgressTimeAudio;
	private CountDownTimer mCountDownTimer;
	private final long startTime = 30 * 1000;
	private final long interval = 1 * 1000;
	private TextView mTvTimer;
	private LinearLayout mLlAudio, mLlVideo;
	private TextView mTvQuestion;
	private ImageView mImvQuestion;
	int i = 0;

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
		mLlAudio = (LinearLayout) findViewById(R.id.ll_audio);
		mTvQuestion = (TextView) findViewById(R.id.tv_question);
		mImvQuestion = (ImageView) findViewById(R.id.imv_question);
		mLlVideo = (LinearLayout) findViewById(R.id.ll_questionVideo);
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
		inviImageQuestion();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_pause:
			startActivity(new Intent(QuestionActivity.this, PauseActivity.class));

			break;
		case R.id.btn_end:
			i++;
			switch (i) {
			case 1:
				inviImageQuestion();
				showAudio();
				break;
			case 2:
				inviAudio();
				showImageQuestion();
				mTvQuestion.setText("What country do you see in the picture?");
				break;
			case 3:
				inviAudio();
				inviImageQuestion();
				mTvQuestion
						.setText("What is the main country of all times in the world?");
				break;
			case 4:
				inviAudio();
				inviImageQuestion();
				showVideo();
				VideoView video = (VideoView)findViewById(R.id.videoView);
				// URL or local path here
				video.setVideoPath("http://download.itcuties.com/teaser/itcuties-teaser-480.mp4");
				video.start();
				mTvQuestion.setText("What country do you see in the movie?");
				break;
			case 5:
				startActivity(new Intent(QuestionActivity.this,
						CompletedActivity.class));
				break;
			default:
				break;
			}

			break;
		default:
			break;
		}
	}

	public void showAudio() {
		// mTvQuestion.setVisibility(View.VISIBLE);
		mLlAudio.setVisibility(View.VISIBLE);
	}

	public void inviAudio() {
		// mTvQuestion.setVisibility(View.GONE);
		mLlAudio.setVisibility(View.GONE);
	}

	public void showImageQuestion() {
		mImvQuestion.setVisibility(View.VISIBLE);
	}

	public void inviImageQuestion() {
		mImvQuestion.setVisibility(View.GONE);
	}

	public void showVideo() {
		mLlVideo.setVisibility(View.VISIBLE);
	}

	public void inviVideo() {
		mLlVideo.setVisibility(View.GONE);
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
