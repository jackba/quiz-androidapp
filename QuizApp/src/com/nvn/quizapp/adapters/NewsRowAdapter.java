package com.nvn.quizapp.adapters;

import java.util.List;

import com.nvn.quizapp.R;
import com.nvn.quizapp.Objects.Exam;
import com.nvn.quizapp.R.id;
import com.nvn.quizapp.utils.SessionManager;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsRowAdapter extends ArrayAdapter<Exam> {

	private Activity activity;
	private List<Exam> items;
	private Exam objBean;
	private int row;

	public NewsRowAdapter(Activity act, int resource, List<Exam> arrayList) {
		super(act, resource, arrayList);
		this.activity = act;
		this.row = resource;
		this.items = arrayList;
	}

	@Override
	public View getView(final int position, View convertView, ViewGroup parent) {
		View view = convertView;
		ViewHolder holder;
		if (view == null) {
			LayoutInflater inflater = (LayoutInflater) activity
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			view = inflater.inflate(row, null);
			holder = new ViewHolder();
			view.setTag(holder);
		} else {
			holder = (ViewHolder) view.getTag();
		}

		if ((items == null) || ((position + 1) > items.size()))
			return view;

		objBean = items.get(position);

		holder.imgExams = (ImageView) view.findViewById(R.id.imv_exams);
		holder.tvTitleExams = (TextView) view.findViewById(R.id.tv_title_exams);
		holder.tvNumberQuestion = (TextView) view
				.findViewById(R.id.tv_number_question);
		holder.tvTimeLimit = (TextView) view.findViewById(R.id.tv_time_exams);
//		holder.imgPurchased = (ImageView) view.findViewById(R.id.imv_purchased);
//		holder.imgPreview = (ImageView) view.findViewById(R.id.imv_preview);
		
		
		holder.tvTitleExams.setText("Title number 1");
		holder.tvNumberQuestion.setText("100 questions");
		holder.tvTimeLimit.setText("1 hour 45 minutes");
		holder.imgExams.setBackgroundResource(R.drawable.ic_demo2);
		
		return view;
	}

	public class ViewHolder {
		public TextView tvTitleExams, tvNumberQuestion, tvTimeLimit;
		public ImageView imgExams, imgPurchased, imgPreview;
	}
}