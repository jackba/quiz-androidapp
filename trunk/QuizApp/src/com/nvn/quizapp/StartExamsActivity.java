package com.nvn.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class StartExamsActivity extends BaseActivity implements OnClickListener {
	private Button mBtnStartExame;
	private SeekBar mSbStartExame;
	private LinearLayout mLlBack;
	int oldProgress;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_start_exams);
		initViews();
		initProperties();
		initListeners();
	}

	@Override
	public void initViews() {
		mBtnStartExame = (Button) findViewById(R.id.btn_start_exame);
		mSbStartExame = (SeekBar) findViewById(R.id.sb_start_exam);
		mLlBack = (LinearLayout) findViewById(R.id.ll_back);
	}

	@Override
	public void initListeners() {
		mBtnStartExame.setOnClickListener(this);
		mLlBack.setOnClickListener(this);
		mSbStartExame.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				seekBar.setProgress(oldProgress);
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				oldProgress = seekBar.getProgress();
				seekBar.setProgress(oldProgress);
			}

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress,
					boolean fromUser) {
				seekBar.setProgress(oldProgress);

			}
		});
	}

	@Override
	public void initProperties() {
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_start_exame:
			startActivity(new Intent(StartExamsActivity.this,
					QuestionActivity.class));
			break;
		case R.id.ll_back:
			finish();
			break;
		default:
			break;
		}
	}

}
