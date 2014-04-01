package com.nvn.quizapp;

import java.util.List;

import com.nvn.quizapp.Objects.Exam;
import com.nvn.quizapp.adapters.NewsRowAdapter;
import com.nvn.quizapp.adapters.NewsRowAnswerAdapter;
import com.nvn.quizapp.utils.SessionManager;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;

public class CompletedActivity extends BaseActivity {
	private ListView mLvAnswer;
	private Context mContext;
	private List<Exam> arrayOfList;
	private NewsRowAnswerAdapter objAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_completed);
		initViews();
		initProperties();
		initListeners();
	}

	@Override
	public void initViews() {
		mLvAnswer = (ListView) findViewById(R.id.lv_answer);
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
		objAdapter = new NewsRowAnswerAdapter(CompletedActivity.this,
				R.layout.item_list_answer, arrayOfList);
		mLvAnswer.setAdapter(objAdapter);
	}
}
