package com.nvn.quizapp;

import com.nvn.quizapp.Objects.Quiz;
import com.nvn.quizapp.utils.SessionManager;
import com.nvn.quizapp.utils.Statics;
import com.nvn.quizapp.ws.BaseWSControl;
import com.nvn.quizapp.ws.BaseWSControl.WebServiceFlag;
import com.nvn.quizapp.ws.GetQuizDataWSControl;
import com.nvn.quizapp.ws.WebServiceCommunicatorListener;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends BaseActivity implements OnClickListener,
		WebServiceCommunicatorListener {

	private ImageView mImvLogo;
	private TextView mTvTitle;
	private Button mBtnRegister, mBtnSignUp;
	private ProgressDialog mPdLoading;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();
		initListeners();
		initProperties();
		
//		getData();
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
