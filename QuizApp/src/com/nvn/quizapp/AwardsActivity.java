package com.nvn.quizapp;

import java.util.List;

import com.nvn.quizapp.Objects.Exam;
import com.nvn.quizapp.adapters.NewsRowAdapter;
import com.nvn.quizapp.adapters.NewsRowAwardAdapter;
import com.nvn.quizapp.utils.SessionManager;

import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

public class AwardsActivity extends BaseActivity {
	private ListView mLvAward;
	private Context mContext;
	private List<Exam> arrayOfList;
	private NewsRowAwardAdapter objAdapter;
	private Button mBtnAwards, mBtnAbout, mBtnExams;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_awards);
		initViews();
		initProperties();
		initListeners();
	}

	@Override
	public void initViews() {
		mLvAward = (ListView) findViewById(R.id.lv_award);
	}

	@Override
	public void initListeners() {
		// TODO Auto-generated method stub

	}

	@Override
	public void initProperties() {
		arrayOfList = SessionManager.getSessionManager().getCurQuiz()
				.getExams();
		setAdapterToListview();
	}

	public void setAdapterToListview() {
		objAdapter = new NewsRowAwardAdapter(AwardsActivity.this,
				R.layout.item_list_awards, arrayOfList);
		mLvAward.setAdapter(objAdapter);
	}
}
