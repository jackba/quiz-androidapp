package com.nvn.quizapp.fragments;

import java.util.List;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.nvn.quizapp.BaseFragment;
import com.nvn.quizapp.R;
import com.nvn.quizapp.Objects.Exam;
import com.nvn.quizapp.adapters.AwardsAdapter;
import com.nvn.quizapp.utils.SessionManager;

public class AwardsFragment extends BaseFragment {
	private ListView mLvAward;
	private List<Exam> arrayOfList;
	private AwardsAdapter objAdapter;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_awards, null);
	}

	@Override
	public void initViews() {
		mLvAward = (ListView) getView().findViewById(R.id.lv_award);
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
		objAdapter = new AwardsAdapter(mActivity,
				R.layout.item_list_awards, arrayOfList);
		mLvAward.setAdapter(objAdapter);
	}
}
