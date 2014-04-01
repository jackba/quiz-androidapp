package com.nvn.quizapp;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends BaseActivity {
	private ImageView mImvResult;
	private TextView mTvShowResult;
	private String mPass = "You have earned \"Super-star\" badge";
	private String mEinstein = "Do you think Einstein created e=mc*c overnight? Try again and you will do better!";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		initViews();
		initProperties();
		initListeners();
	}

	@Override
	public void initViews() {
		mImvResult = (ImageView) findViewById(R.id.imv_result);
		mTvShowResult = (TextView) findViewById(R.id.tv_show_result);
	}

	@Override
	public void initListeners() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initProperties() {
		mImvResult.setBackgroundResource(R.drawable.ic_super_star);
		mTvShowResult.setText(mPass);
	}
}
