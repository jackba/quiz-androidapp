package com.nvn.quizapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nvn.quizapp.Objects.Quiz;
import com.nvn.quizapp.utils.SessionManager;
import com.nvn.quizapp.utils.Statics;
import com.nvn.quizapp.ws.BaseWSControl;
import com.nvn.quizapp.ws.BaseWSControl.WebServiceFlag;
import com.nvn.quizapp.ws.GetQuizDataWSControl;
import com.nvn.quizapp.ws.WebServiceCommunicatorListener;

public class MainActivity extends BaseActivity implements OnClickListener,
		WebServiceCommunicatorListener {

	private ImageView mImvLogo;
	private TextView mTvTitle;
	private Button mBtnRegister, mBtnSignUp;
	private ProgressDialog mPdLoading;
	private static int SPLASH_TIME_OUT = 3000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();
		initListeners();
		initProperties();

		// getData();
	}

	@Override
	public void initViews() {
		mImvLogo = (ImageView) findViewById(R.id.imv_logo);
		mTvTitle = (TextView) findViewById(R.id.tv_title);
		mBtnRegister = (Button) findViewById(R.id.btn_register);
		mBtnSignUp = (Button) findViewById(R.id.btn_signup);

	}

	@Override
	public void initListeners() {
		mBtnRegister.setOnClickListener(this);
		mBtnSignUp.setOnClickListener(this);
	}

	@Override
	public void initProperties() {
		mImvLogo.setBackgroundResource(R.drawable.ic_logo);
		mTvTitle.setText("VCA EXAMEN TEST");
		mPdLoading = new ProgressDialog(this);
		mPdLoading.setCancelable(false);
		mPdLoading.setMessage("Loading...");
		new Handler().postDelayed(new Runnable() {

			/*
			 * Showing splash screen with a timer. This will be useful when you
			 * want to show case your app logo / company
			 */

			@Override
			public void run() {
				// This method will be executed once the timer is over
				// Start your app main activity
				Intent i = new Intent(MainActivity.this, HomeActivity.class);
				startActivity(i);

				// close this activity
				finish();
			}
		}, SPLASH_TIME_OUT);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_signup:
			// if (SessionManager.getSessionManager().getCurQuiz() != null) {
			startActivity(new Intent(MainActivity.this, SignUpActivity.class));
			// }
			break;
		case R.id.btn_register:
			// if (SessionManager.getSessionManager().getCurQuiz() != null) {
			startActivity(new Intent(MainActivity.this, SignInActivity.class));
			// }
			break;
		default:
			break;
		}
	}

	private void getData() {
		new GetQuizDataWSControl(this, this, Statics.QUIZ_ID).execute();
	}

	@Override
	public void onConnectionOpen(BaseWSControl wsControl, WebServiceFlag flag) {
		mPdLoading.show();
	}

	@Override
	public void onConnectionError(BaseWSControl wsControl, WebServiceFlag flag,
			String error) {
		mPdLoading.dismiss();
		Statics.showToast(this, error);
	}

	@Override
	public void onConnectionDone(BaseWSControl wsControl, WebServiceFlag flag,
			Object result) {
		mPdLoading.dismiss();
		if (flag == WebServiceFlag.GET_QUIZ_DATA) {
			SessionManager.getSessionManager().setCurQuiz((Quiz) result);
		}
	}

	@Override
	public void onUpdateData(BaseWSControl wsControl, WebServiceFlag flag,
			Object data) {
	}
}
