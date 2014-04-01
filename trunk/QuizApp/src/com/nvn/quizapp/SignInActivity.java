package com.nvn.quizapp;

import com.nvn.quizapp.fragments.ExamsFragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SignInActivity extends BaseActivity implements OnClickListener {
	private Button mBtnSignUp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sign_up);
		initViews();
		initProperties();
		initListeners();
	}

	@Override
	public void initViews() {
		mBtnSignUp = (Button) findViewById(R.id.btn_sign_up);
	}

	@Override
	public void initListeners() {
		mBtnSignUp.setOnClickListener(this);
	}

	@Override
	public void initProperties() {
		// TODO Auto-generated method stub

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_sign_up:
			startActivity(new Intent(SignInActivity.this, HomeActivity.class));
			break;

		default:
			break;
		}
	}

}
