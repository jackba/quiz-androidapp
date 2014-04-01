package com.nvn.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class QuestionActivity extends BaseActivity implements OnClickListener {
	private Button mBtnPause, mBtnEnd;
	private SeekBar mSbNumberQuestion, mSbTimeAudio;
	int oldProgressNumberQuestion, oldProgressTimeAudio;

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
		// TODO Auto-generated method stub

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

}
