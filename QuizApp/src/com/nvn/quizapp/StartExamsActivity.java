package com.nvn.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class StartExamsActivity extends BaseActivity implements OnClickListener {
	private Button mBtnStartExame;

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
	}

	@Override
	public void initListeners() {
		mBtnStartExame.setOnClickListener(this);
	}

	@Override
	public void initProperties() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_start_exame:
			startActivity(new Intent(StartExamsActivity.this,
					QuestionActivity.class));
			break;

		default:
			break;
		}
	}

}