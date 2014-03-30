package com.nvn.quizapp;

import com.nvn.quizapp.Objects.Quiz;
import com.nvn.quizapp.utils.SessionManager;
import com.nvn.quizapp.utils.Statics;
import com.nvn.quizapp.ws.BaseWSControl;
import com.nvn.quizapp.ws.BaseWSControl.WebServiceFlag;
import com.nvn.quizapp.ws.GetQuizDataWSControl;
import com.nvn.quizapp.ws.WebServiceCommunicatorListener;

import android.app.ProgressDialog;
import android.os.Bundle;

public class MainActivity extends BaseActivity implements
		WebServiceCommunicatorListener {
	private ProgressDialog mPdLoading;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initViews();
		initListeners();
		initProperties();
		getData();
	}

	@Override
	public void initViews() {

	}

	@Override
	public void initListeners() {

	}

	@Override
	public void initProperties() {
		mPdLoading = new ProgressDialog(this);
		mPdLoading.setCancelable(false);
		mPdLoading.setMessage("Loading...");
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
