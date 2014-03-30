package com.nvn.quizapp;

import java.util.ArrayList;
import java.util.List;

import com.nvn.quizapp.Objects.Exam;
import com.nvn.quizapp.Objects.Quiz;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class ExamsActivity extends BaseActivity implements OnItemClickListener {
	private ListView mLvExams;
	private Context mContext;
	List<Exam> arrayOfList;
	NewsRowAdapter objAdapter;

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
		arrayOfList = new ArrayList<Exam>();
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub

	}

	public void setAdapterToListview() {
		objAdapter = new NewsRowAdapter(ExamsActivity.this,
				R.layout.item_list_exams, arrayOfList);
		mLvExams.setAdapter(objAdapter);
	}
}
