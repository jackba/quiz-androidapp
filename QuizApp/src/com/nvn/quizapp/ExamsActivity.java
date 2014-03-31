package com.nvn.quizapp;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.io.SessionOutputBuffer;

import com.nvn.quizapp.Objects.Exam;
import com.nvn.quizapp.Objects.Quiz;
import com.nvn.quizapp.adapters.NewsRowAdapter;
import com.nvn.quizapp.utils.SessionManager;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.Toast;

public class ExamsActivity extends BaseActivity implements OnItemClickListener {
	private ListView mLvExams;
	private Context mContext;
	private List<Exam> arrayOfList;
	private NewsRowAdapter objAdapter;

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
	}

	@Override
	public void initListeners() {
		mLvExams.setOnItemClickListener(this);
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
		 Toast.makeText(this, "Show", Toast.LENGTH_LONG).show();
		startActivity(new Intent(ExamsActivity.this, StartExamsActivity.class));
	}

	public void setAdapterToListview() {
		objAdapter = new NewsRowAdapter(ExamsActivity.this,
				R.layout.item_list_exams, arrayOfList);
		mLvExams.setAdapter(objAdapter);
	}
}
