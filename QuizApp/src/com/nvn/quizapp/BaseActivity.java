package com.nvn.quizapp;

import android.app.Activity;

public abstract class BaseActivity extends Activity {

	public abstract void initViews();

	public abstract void initListeners();

	public abstract void initProperties();

}
