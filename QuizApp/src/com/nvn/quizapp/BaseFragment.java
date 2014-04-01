package com.nvn.quizapp;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

public abstract class BaseFragment extends Fragment {
	protected Activity mActivity;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mActivity = activity;
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		initViews();
		initListeners();
		initProperties();
	}

	public abstract void initViews();

	public abstract void initListeners();

	public abstract void initProperties();
}
