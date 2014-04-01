package com.nvn.quizapp.fragments;

import java.util.List;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

import com.nvn.quizapp.BaseFragment;
import com.nvn.quizapp.R;
import com.nvn.quizapp.StartExamsActivity;
import com.nvn.quizapp.Objects.Exam;
import com.nvn.quizapp.adapters.ExamsAdapter;
import com.nvn.quizapp.utils.SessionManager;

public class ExamsFragment extends BaseFragment implements OnItemClickListener{
	private ListView mLvExams;
	private List<Exam> arrayOfList;
	private ExamsAdapter objAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_exams, null);
	}

	@Override
	public void initViews() {
		mLvExams = (ListView)getView().findViewById(R.id.lv_exams);
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
		startActivity(new Intent(mActivity, StartExamsActivity.class));
	}

	public void setAdapterToListview() {
		objAdapter = new ExamsAdapter(mActivity,
				R.layout.item_list_exams, arrayOfList);
		mLvExams.setAdapter(objAdapter);
	}

}
