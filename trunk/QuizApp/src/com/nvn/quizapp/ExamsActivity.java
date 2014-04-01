package com.nvn.quizapp;

import java.util.List;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.nvn.quizapp.Objects.Exam;
import com.nvn.quizapp.adapters.NewsRowAdapter;
import com.nvn.quizapp.utils.SessionManager;

public class ExamsActivity extends BaseActivity implements OnItemClickListener,
		OnClickListener {
	private ListView mLvExams;
	private Context mContext;
	private List<Exam> arrayOfList;
	private NewsRowAdapter objAdapter;
	private Button mBtnAwards, mBtnAbout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_exams);
		initViews();
		initProperties();
		initListeners();
	}

	@Override
	public void initViews() {
		mLvExams = (ListView) findViewById(R.id.lv_exams);
		mBtnAwards = (Button) findViewById(R.id.btn_awards);
		mBtnAbout = (Button)findViewById(R.id.btn_about);
	}

	@Override
	public void initListeners() {
		mLvExams.setOnItemClickListener(this);
		mBtnAwards.setOnClickListener(this);
		mBtnAbout.setOnClickListener(this);
	}

	@Override
	public void initProperties() {
		arrayOfList = SessionManager.getSessionManager().getCurQuiz()
				.getExams();
		setAdapterToListview();
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int rg2, long arg3) {
		// SessionManager.getSessionManager().setCurExam(arrayOfList.get(rg2));
		startActivity(new Intent(ExamsActivity.this, StartExamsActivity.class));
	}

	public void setAdapterToListview() {
		objAdapter = new NewsRowAdapter(ExamsActivity.this,
				R.layout.item_list_exams, arrayOfList);
		mLvExams.setAdapter(objAdapter);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_awards:
			startActivity(new Intent(ExamsActivity.this, AwardsActivity.class));
			break;
		case R.id.btn_about:
			startActivity(new Intent(ExamsActivity.this, AboutActivity.class));
			break;
		default:
			break;
		}
	}
}
