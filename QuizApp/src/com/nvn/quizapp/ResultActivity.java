package com.nvn.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultActivity extends BaseActivity implements OnClickListener {
	private ImageView mImvResult;
	private TextView mTvShowResult;
	private Button mBtnSeeOur;
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
		mBtnSeeOur = (Button) findViewById(R.id.btn_see_our_reco);
	}

	@Override
	public void initListeners() {
		mBtnSeeOur.setOnClickListener(this);
	}

	@Override
	public void initProperties() {
		mImvResult.setBackgroundResource(R.drawable.ic_super_star);
		mTvShowResult.setText(mPass);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_see_our_reco:
			startActivity(new Intent(ResultActivity.this,
					RecommendationsActivity.class));
			break;

		default:
			break;
		}
	}
}
