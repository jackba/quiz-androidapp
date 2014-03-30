package com.nvn.quizapp.ws;

import java.text.SimpleDateFormat;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;

public abstract class BaseWSControl extends AsyncTask<Void, Object, Object> {

	protected Context mContext;
	protected WebServiceCommunicatorListener mWCListener;
	protected String mError;
	protected WebServiceFlag mFlag;

	public enum WebServiceFlag {

		GET_QUIZ_DATA

	}

	/*
	 * 
	 * constructor
	 */
	public BaseWSControl(Context context,
			WebServiceCommunicatorListener listener, WebServiceFlag flag) {
		this.mContext = context;
		this.mWCListener = listener;
		mFlag = flag;
	}

	@Override
	protected void onPreExecute() {
		if (mWCListener != null) {
			mWCListener.onConnectionOpen(this, mFlag);
		}
		super.onPreExecute();
	}

	@Override
	protected void onPostExecute(Object result) {
		if (result == null) {
			if (mWCListener != null && mError != null) {
				mWCListener.onConnectionError(this, mFlag, mError);
				return;
			}
		}
		if (mWCListener != null) {
			mWCListener.onConnectionDone(this, mFlag, result);
		}

		super.onPostExecute(result);
	}

	@Override
	protected void onProgressUpdate(Object... values) {
		if (mWCListener != null) {
			mWCListener.onUpdateData(this, mFlag, values[0]);
		}
		super.onProgressUpdate(values);
	}

	@SuppressLint("SimpleDateFormat")
	public static long parseDate(String time) {
		if (time.charAt(time.length() - 1) == 'Z') {
			time = time.substring(0, time.length() - 1);
		}
		SimpleDateFormat formater = new SimpleDateFormat(
				"yyyy-MM-dd'T'HH:mm:ss.SSS");
		try {
			return formater.parse(time).getTime();
		} catch (Exception e) {
			return 0;
		}

	}
}
