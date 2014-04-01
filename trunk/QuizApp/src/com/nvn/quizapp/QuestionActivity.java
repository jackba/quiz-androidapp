package com.nvn.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class QuestionActivity extends BaseActivity implements OnClickListener {
	private Button mBtnPause, mBtnEnd;

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
	}

	@Override
	public void initListeners() {
		mBtnPause.setOnClickListener(this);
		mBtnEnd.setOnClickListener(this);
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
