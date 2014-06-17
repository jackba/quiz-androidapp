package com.nvn.quizapp;

import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.nvn.quizapp.Objects.Exam;
import com.nvn.quizapp.Objects.Quiz;
import com.nvn.quizapp.utils.SessionManager;
import com.nvn.quizapp.utils.Statics;
import com.nvn.quizapp.ws.BaseWSControl;
import com.nvn.quizapp.ws.BaseWSControl.WebServiceFlag;
import com.nvn.quizapp.ws.GetExamDataWSControl;
import com.nvn.quizapp.ws.WebServiceCommunicatorListener;

public class MainActivity extends BaseActivity implements OnClickListener,
		WebServiceCommunicatorListener {

	private ImageView mImvLogo;
	private TextView mTvTitle;
	private Button mBtnRegister, mBtnSignUp;
	private ProgressDialog mPdLoading;
	private boolean dataOK, splashOK;
	private static int SPLASH_TIME_OUT = 3000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();
		initListeners();
		initProperties();

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
		mTvTitle.setText(Statics.APP_NAME);
		mPdLoading = new ProgressDialog(this);
		mPdLoading.setCancelable(false);
		mPdLoading.setMessage("Loading...");
		
		dataOK = false;
		splashOK = false;
		
		getData();
		
		new Handler().postDelayed(new Runnable() {

			/*
			 * Showing splash screen with a timer. This will be useful when you
			 * want to show case your app logo / company
			 */

			@Override
			public void run() {
				// This method will be executed once the timer is over
				// Start your app main activity
				splashOK = true;
				
				redirectToHome();
			}
		}, SPLASH_TIME_OUT);
	}

	private void redirectToHome(){
		if(splashOK && dataOK){
			Intent i = new Intent(MainActivity.this, HomeActivity.class);
			startActivity(i);
			finish();
		}
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
		new GetExamDataWSControl(this, this).execute();
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

	@SuppressWarnings("unchecked")
	@Override
	public void onConnectionDone(BaseWSControl wsControl, WebServiceFlag flag,
			Object result) {
		mPdLoading.dismiss();
		if (flag == WebServiceFlag.GET_EXAM_DATA) {
			dataOK = true;
			SessionManager.getSessionManager().setExams((ArrayList<Exam>) result);
			
			redirectToHome();
		}
	}

	@Override
	public void onUpdateData(BaseWSControl wsControl, WebServiceFlag flag,
			Object data) {
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		if(!Statics.isNetworkConnected(this)){
			new AlertDialog.Builder(MainActivity.this)
			.setTitle("Notice")
			.setMessage("Oops! No internet connection.")
			.setPositiveButton("Ok",
					new DialogInterface.OnClickListener() {

						@Override
						public void onClick(
								DialogInterface dialog,
								int which) {
							finish();
						}
					}).show();
		}
	}
}
