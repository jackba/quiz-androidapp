package com.nvn.quizapp;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.nvn.quizapp.Objects.Exam;
import com.nvn.quizapp.adapters.AnswersAdapter;
import com.nvn.quizapp.utils.SessionManager;

public class CompletedActivity extends BaseActivity implements OnClickListener {
	private ListView mLvAnswer;
	private Context mContext;
	private List<Exam> arrayOfList;
	private AnswersAdapter objAdapter;
	private Button mBtnShowResult;

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
		mBtnShowResult = (Button) findViewById(R.id.btn_show_result);
	}

	@Override
	public void initListeners() {
		mBtnShowResult.setOnClickListener(this);
	}

	@Override
	public void initProperties() {
		arrayOfList = SessionManager.getSessionManager().getExams();
		setAdapterToListview();

	}

	public void setAdapterToListview() {
		objAdapter = new AnswersAdapter(CompletedActivity.this,
				R.layout.item_list_answer, arrayOfList);
		mLvAnswer.setAdapter(objAdapter);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_show_result:
			startActivity(new Intent(CompletedActivity.this,
					ResultActivity.class));
			break;

		default:
			break;
		}
	}
}
