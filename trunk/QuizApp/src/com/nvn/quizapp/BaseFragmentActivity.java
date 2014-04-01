package com.nvn.quizapp;

import android.support.v4.app.FragmentActivity;

public abstract class BaseFragmentActivity extends FragmentActivity {

	public abstract void initViews();

	public abstract void initListeners();

	public abstract void initProperties();
}
