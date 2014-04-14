package com.nvn.quizapp;

import com.nvn.quizapp.fragments.AboutFragment;
import com.nvn.quizapp.fragments.AwardsFragment;
import com.nvn.quizapp.fragments.ExamsFragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class HomeActivity extends BaseFragmentActivity implements
		OnClickListener {
	private TextView mTvTitle;
	private Button mBtnAwards, mBtnAbout, mBtnExams, mLastButton;

	@Override
	protected void onCreate(Bundle arg0) {
		super.onCreate(arg0);
		setContentView(R.layout.activity_home);

		initViews();
		initListeners();
		initProperties();
	}

	@Override
	public void initViews() {
		mTvTitle = (TextView) findViewById(R.id.tv_title);
		mBtnExams = (Button) findViewById(R.id.btn_exams);
		mBtnAwards = (Button) findViewById(R.id.btn_awards);
		mBtnAbout = (Button) findViewById(R.id.btn_about);
	}

	@Override
	public void initListeners() {
		mBtnExams.setOnClickListener(this);
		mBtnAwards.setOnClickListener(this);
		mBtnAbout.setOnClickListener(this);
	}

	@Override
	public void initProperties() {
		setNewPage(new ExamsFragment());
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_exams:
			setNewPage(new ExamsFragment());
			break;
		case R.id.btn_awards:
			setNewPage(new AwardsFragment());
			break;
		case R.id.btn_about:
			setNewPage(new AboutFragment());
			break;
		}
	}

	public void setNewPage(Fragment fragment) {
		while (getSupportFragmentManager().getBackStackEntryCount() > 0) {
			getSupportFragmentManager().popBackStackImmediate();
		}
		if (fragment instanceof ExamsFragment) {
			mTvTitle.setText(R.string.exams);
			changeBtnState(mBtnExams);
		} else if (fragment instanceof AwardsFragment) {
			mTvTitle.setText(R.string.awards);
			changeBtnState(mBtnAwards);
		} else {
			mTvTitle.setText(R.string.about);
			changeBtnState(mBtnAbout);
		}

		try {
			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.content_fragment, fragment, "currentFragment")
					.commitAllowingStateLoss();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void changeBtnState(Button curBtn) {
		if (mLastButton != null) {
			mLastButton.setSelected(false);
		}
		curBtn.setSelected(true);
		mLastButton = curBtn;
	}
}
